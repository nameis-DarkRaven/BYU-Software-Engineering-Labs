package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWorldHandler implements RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context) {
        String greetings = "Emilee’s first Terraform project";
        System.out.println(greetings);
        return new Response(greetings);
    }
}

// C:\Users\emile\OneDrive\Documents\Emilee's Folder\College\Fall 2025\CS 204\Week 5\HelloLambdaWorld\target\HelloLambdaWorld-1.0-SNAPSHOT.jar