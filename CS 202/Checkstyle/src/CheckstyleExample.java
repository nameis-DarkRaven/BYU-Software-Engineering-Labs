//import java.net.ServerSocket;
//import java.net.Socket;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.util.Scanner;

public final class CheckstyleExample {

    private CheckstyleExample() {
        //No one should be instantiating this class
    }

/**
 *    This is a javadoc comment.
 * @param args These are the arguments.
 */
    public static void main(final String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Error: No port specified. Exiting. "
                    + "This should be much longer than is allowed in the"
                    + " settings for checkstyle. It will throw an error,");
            return;
        }
        String portString = args[0];

        int port = Integer.parseInt(portString);

        boolean portNotFound = true;

        HttpServer server = null;

        while (portNotFound) {
            portNotFound = false;

            try {
                server = HttpServer.create(new InetSocketAddress(port), 0);
            } catch (Exception e) {
                System.out.println("Error: port already in use."
                        + "                                      \n");
                System.out.println("Enter port: ");

                Scanner scanner = new Scanner(System.in);
                portString = scanner.nextLine();

                port = Integer.parseInt(portString);

                portNotFound = true;
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
