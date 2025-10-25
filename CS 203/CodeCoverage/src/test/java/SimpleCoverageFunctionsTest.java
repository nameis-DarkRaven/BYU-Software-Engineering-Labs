import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCoverageFunctionsTest {
    SimpleCoverageFunctions testClass;

    @BeforeEach
    public void setUp() throws Exception {
        testClass = new SimpleCoverageFunctions();
    }

    @Test
    public void addTwoNumTest(){
        int sum = testClass.addTwoNum(1, 2);
        assertEquals(3, sum);
    }

    @Test
    void returnLargest() {
        assertEquals(7, testClass.returnLargest(7, 5));
        assertEquals(6, testClass.returnLargest(2, 6));
        //You still need to write at least one more test for full branch coverage
    }

    @Test
    void doWeirdStuff() {
        assertEquals(12, testClass.doWeirdStuff(3, 4, 6));
        assertEquals(1, testClass.doWeirdStuff(6, 3, 4));
        assertEquals(4, testClass.doWeirdStuff(6, 4, 3));

    }
}