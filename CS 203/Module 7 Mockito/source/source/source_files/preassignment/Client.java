package intro;

/**
 * This represents a very basic client that just reports the code it
 * receives from the server.  This is the class that is being tested, but it
 * has a dependency on the Server class that can be unpredictable.  To make sure that
 * the client behaves as expected when receiving a code from the server,
 * the server needs to be mocked to allow us to control exactly what response
 * the client receives.
 */
public class Client {
    public String doStuff(String message){
        int response = getServer().getResponse(message);
        return switch (response) {
            case 200 -> "OK";
            case 400 -> "Error code 400: Bad Request.";
            case 401 -> "Error code 401: Unauthorized.";
            case 404 -> "Error code 404: File not found.";
            default -> "Internal server error";
        };
    }

    public Server getServer(){
        return new Server();
    }
}
