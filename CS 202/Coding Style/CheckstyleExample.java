//import java.net.ServerSocket;
//import java.net.Socket;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.util.Scanner;

public class CheckstyleExample {

 private CheckstyleExample() {
  //No one should be instantiating this class
 }

 public static void main(String[] args) throws IOException {
  if (args.length == 0) {
   System.out.println("Error: No port specified. Exiting. This should be much longer than is allowed in the settings for checkstyle. It will throw an error,");
   return;
  } else {
  }

  String portString=args[0];

  int port=Integer.parseInt(portString);

  boolean portNotFound=true;

  HttpServer server=null;

  while (portNotFound) {
   portNotFound=false;

   try {
    server=HttpServer.create(new InetSocketAddress(port), 0);
   } catch (Exception e) {
    System.out.println("Error: port already in use.                                      \n");
    System.out.printf("Enter port: ");

    Scanner scanner=new Scanner(System.in);
    portString=scanner.nextLine();

    port=Integer.parseInt(portString);

    portNotFound=true;
   }
  }


  System.out.printf("Server listening on port: %d\n", port);

  server.start();

  while (true) {
   //Server does something useful

   continue;
  }
 }
}