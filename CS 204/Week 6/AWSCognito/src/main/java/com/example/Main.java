package com.example;

import java.util.Map;
import java.util.Scanner;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthFlowType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.SignUpRequest;

public class Main {
    private static Scanner scanner;
    private static final String clientId = "6u8uiu76f6id23ffga8caksevh"; // replace with your Cognito App Client ID

    public static void main(String[] args) {
        final String intro = "-----  Welcome to the Cognito Tutorial App!  -----";
        final String usage = """

                To register, type 'r'
                To log in, type 'l'
                To exit, type 'q'

                --------------------------------------------------
                """;
        System.out.println(intro);
        System.out.println(usage);

        scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            switch (input) {
                case "r":
                    register();
                    return;
                case "l":
                    login();
                    return;
                case "q":
                    return;
                default:
                    System.out.println(usage);
            }
        }
    }

    static void register() {
        // get user input for a username, password, and email

        System.out.println("Enter a username: ");
        String username = scanner.next();
        System.out.println("Enter a password: ");
        String password = scanner.next();
        System.out.println("Enter an email: ");
        String email = scanner.next();

        // Initialize the CognitoIdentityProviderClient here
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .region(Region.US_EAST_1)
                .build();
        // Create a SignUpRequest object using the clientId field along with the
        // username, password, and email
        SignUpRequest signUpRequest = SignUpRequest.builder()
                .clientId(clientId)
                .username(username)
                .password(password)
                .userAttributes(AttributeType.builder()
                        .name("email")
                        .value(email)
                        .build())
                .build();


        try {
            // Call the signUp method here
            cognitoClient.signUp(signUpRequest);

            System.out.println("User registration successful. A verification code has been sent to your email.");

            // Prompt the user to enter the verification code
            System.out.println("Enter the verification code: ");
            String code = scanner.next();

            // Create a ConfirmSignUpRequest
            ConfirmSignUpRequest confirmSignUpRequest = ConfirmSignUpRequest.builder()
                    .clientId(clientId)
                    .username(username)
                    .confirmationCode(code)
                    .build();

            // Call the confirmSignUp method
            cognitoClient.confirmSignUp(confirmSignUpRequest);
            System.out.println("User verification successful.");

        } catch (CognitoIdentityProviderException e) {
            System.out.println("Error registering user: " + e.awsErrorDetails().errorMessage());
        }
    }

    static void login() {
        // Get user input for a username and password
        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();

        // Initialize the CognitoIdentityProviderClient here
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .region(Region.US_EAST_1)
                .build();
        // Create an InitiateAuthRequest object using the clientId field along with the
        // auth parameters USERNAME and PASSWORD
        InitiateAuthRequest authRequest = InitiateAuthRequest.builder()
                .authFlow(AuthFlowType.USER_PASSWORD_AUTH)
                .clientId(clientId)                .authParameters(Map.of("USERNAME", username, "PASSWORD", password))
                .build();

        try {
            // Call the initiateAuth method here
            cognitoClient.initiateAuth(authRequest);

            // Print a message for successful login
            System.out.println(username + " logged in.");

        } catch (CognitoIdentityProviderException e) {
            // catch any CognitoIdentityProviderExceptions and print the error message
            System.out.println("Error logging in user: " + e.awsErrorDetails().errorMessage());
        }
    }
}