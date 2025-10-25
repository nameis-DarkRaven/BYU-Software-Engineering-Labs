package intro;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientTest {

    static Client clientUnderTest;

    @BeforeAll
    static void setUp() {
        clientUnderTest = new Client();
        /*
        These lines allow us to insert a fake server into
        the client object that we are testing.  Spies will be explained more
        in a later module, you can ignore that for now.
         */
//        clientUnderTest = Mockito.spy(new Client());

        /*
        This creates a Mock Server.  It copies the interface of the Server class,
        like the function signatures, but the implementation of the functions are ignored.
         */
//        Server mockServer = Mockito.mock(Server.class);

        /*
        This makes the mockServer be returned when the getServer() function
        is called in the Client class.
         */
//        Mockito.when(clientUnderTest.getServer()).thenReturn(mockServer);

        /*
        These lines define the behavior of the mockServer.  When the function inside the when() method is called,
        the mock will return the value specified in the thenReturn() parameter.
        For example, the first line configures the mockServer to return the int 200 whenever the function
        getResponse() is called with the parameter "OK".
         */
//        Mockito.when(mockServer.getResponse("OK")).thenReturn(200);
//        Mockito.when(mockServer.getResponse("BadRequest")).thenReturn(400);
//        Mockito.when(mockServer.getResponse("Unauthorized")).thenReturn(401);
//        Mockito.when(mockServer.getResponse("FileNotFound")).thenReturn(404);
//        Mockito.when(mockServer.getResponse("InternalError")).thenReturn(500);
    }

    /*
    These tests will pass and fail inconsistently due to the randomness
    of the server.  Mocking will allow us to use a fake server that returns
    codes that we tell it to.  By controlling the response values returned by the
    mocked server, we can test that the client handles these response values correctly.
    Uncomment the code blocks in the setUp() function to enable the mocked Server
    to see the tests pass.
     */

    @Test
    public void shouldReturnBadRequest_whenServerReturns400() {
        String answer = clientUnderTest.doStuff("BadRequest");
        assertTrue(answer.contains("400"), "Server did not return expected code. Instead received: " + answer);
    }

    @Test
    public void shouldReturnUnauthorized_whenServerReturns401() {
        String answer = clientUnderTest.doStuff("Unauthorized");
        assertTrue(answer.contains("401"), "Server did not return expected code. Instead received: " + answer);
    }

    @Test
    public void shouldReturnFileNotFound_whenServerReturns404() {
        String answer = clientUnderTest.doStuff("FileNotFound");
        assertTrue(answer.contains("404"), "Server did not return expected code. Instead received: " + answer);
    }

    @Test
    public void shouldReturnOK_whenServerReturns200() {
        String answer = clientUnderTest.doStuff("OK");
        assertTrue(answer.contains("OK"), "Server did not return expected code. Instead received: " + answer);
    }

    @Test
    public void shouldReturnInternalServerError_whenServerReturnsUnexpectedCode() {
        String answer = clientUnderTest.doStuff("InternalError");
        assertTrue(answer.contains("Internal server error"), "Server did not return expected code. Instead received: " + answer);
    }


}
