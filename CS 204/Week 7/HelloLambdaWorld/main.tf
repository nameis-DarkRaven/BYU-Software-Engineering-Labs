terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.4.0"
    }
    time = {
      source  = "hashicorp/time"
      version = "0.13.1"
    }
  }
}

provider "aws" {
  region = "us-east-1"
}

data "aws_iam_policy_document" "role" {
  statement {
    effect = "Allow"
    principals {
      identifiers = ["lambda.amazonaws.com"]
      type        = "Service"
    }
    actions = ["sts:AssumeRole"]
  }
}

resource "aws_iam_role" "part_one_role" {
  assume_role_policy = data.aws_iam_policy_document.role.json
}

resource "aws_lambda_function" "part_one_function" {
  function_name    = "204lambdafunction"
  role             = aws_iam_role.part_one_role.arn
  filename         = "./target/HelloLambdaWorld-1.0-SNAPSHOT.jar"
  runtime          = "java17"
  handler          = "example.HelloWorldHandler"
  source_code_hash = filebase64sha256("./target/HelloLambdaWorld-1.0-SNAPSHOT.jar")
}

resource "aws_api_gateway_rest_api" "HelloWorldAPI" {
  name = "AssignmentAPIGateway"
  endpoint_configuration {
    types = ["REGIONAL"]
  }
}

resource "aws_api_gateway_resource" "HelloWorld" {
  parent_id   = aws_api_gateway_rest_api.HelloWorldAPI.root_resource_id
  path_part   = "HelloWorld"
  rest_api_id = aws_api_gateway_rest_api.HelloWorldAPI.id
}

resource "aws_api_gateway_method" "HelloWorldGatewayMethod" {
  authorization = "NONE"
  http_method   = "ANY"
  resource_id   = aws_api_gateway_resource.HelloWorld.id
  rest_api_id   = aws_api_gateway_rest_api.HelloWorldAPI.id
}

resource "aws_api_gateway_integration" "HelloWorldGatewayIntegration" {
  http_method = aws_api_gateway_method.HelloWorldGatewayMethod.http_method
  resource_id = aws_api_gateway_resource.HelloWorld.id
  rest_api_id = aws_api_gateway_rest_api.HelloWorldAPI.id
  type        = "AWS"
  integration_http_method = "POST"
  content_handling = "CONVERT_TO_TEXT"
  uri = aws_lambda_function.part_one_function.invoke_arn
}

resource "aws_api_gateway_method_response" "HelloWorldGatewayMethodResponse" {
  http_method = aws_api_gateway_method.HelloWorldGatewayMethod.http_method
  resource_id = aws_api_gateway_resource.HelloWorld.id
  rest_api_id = aws_api_gateway_rest_api.HelloWorldAPI.id
  status_code = "200"
  response_models = {"application/json" = "Empty"}
}

resource "aws_api_gateway_integration_response" "HelloWorldGatewayIntegrationResponse" {
  depends_on = [time_sleep.wait_30_seconds]
  http_method = aws_api_gateway_method.HelloWorldGatewayMethod.http_method
  resource_id = aws_api_gateway_resource.HelloWorld.id
  rest_api_id = aws_api_gateway_rest_api.HelloWorldAPI.id
  status_code = "200"
}

resource "time_sleep" "wait_30_seconds" {
  create_duration = "30s"
}

resource "aws_api_gateway_deployment" "HelloWorldGatewayDeployment" {
  rest_api_id = aws_api_gateway_rest_api.HelloWorldAPI.id
  stage_name = "test"
  depends_on = [aws_api_gateway_integration.HelloWorldGatewayIntegration,
    aws_api_gateway_integration_response.HelloWorldGatewayIntegrationResponse,
    aws_api_gateway_method_response.HelloWorldGatewayMethodResponse]
}

resource "aws_lambda_permission" "HelloWorldLambdaPermission" {
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.part_one_function.function_name
  principal     = "apigateway.amazonaws.com"
  source_arn = "${aws_api_gateway_rest_api.HelloWorldAPI.execution_arn}/*"
}