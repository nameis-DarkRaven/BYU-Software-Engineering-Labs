package intro;

import java.util.Random;

/**
 * This is a very basic class that picks a random code and returns it.
 * There is no way to guarantee which code will be sent to the client,
 * so in order to test that the client behaves as expected the server
 * will need to be mocked, allowing us to control what is returned.
 */
public class Server {
    private final Random random;
    private static final int[] RESPONSE_CODES = {200, 400, 401, 404};

    public Server(){
        random = new Random();
    }

    public int getResponse(String message){
        return RESPONSE_CODES[random.nextInt(4)];
    }

}
