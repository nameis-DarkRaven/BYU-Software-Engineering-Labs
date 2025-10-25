import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HarderCoverageFunctionsTest {
    HarderCoverageFunctions testClass;

    @BeforeEach
    public void setUp() throws Exception {
        testClass = new HarderCoverageFunctions();
    }

    @Nested
    class castSpellsTests {
        @Test
        public void noMagicTest() {
            assertEquals("The spell fizzles in front of you.", testClass.castSpells(5, 0, 4, 1));
        }

        @Test
        public void zeroWandDurabilityTest() {
            assertEquals("The spell fizzles in front of you.", testClass.castSpells(5, 40, 0, 1));
        }

        @Test
        public void killMonsterTest() {
            assertEquals("The spell destroys the monster!", testClass.castSpells(2, 10, 1, 1));
        }

        @Test
        public void zapMonsterTest() {
            assertEquals("The spell zaps the monster!", testClass.castSpells(7, 90, 8, 5));
        }

        @Test
        public void youWinTest() {
            assertEquals("You win!", testClass.castSpells(0, 50, 5, 0));
        }

        @Test
        public void noSpells() {
            assertEquals("Monster is still alive", testClass.castSpells(245, 30, 5, 0));

        }
    }

    @Nested
    class truthFinderTests {
        @Test
        public void trueTrueFalseTest() {
            assertEquals("Well that might be true", testClass.truthFinder(true, true, false));
        }

        @Test
        public void trueFalseTrueTest() {
            assertEquals("Well I guess that is true too", testClass.truthFinder(true, false, true));
        }

        @Test
        public void falseTrueTrueTest() {
            assertEquals("YOU FOUND THE TRUTH!", testClass.truthFinder(false, true, true));
        }

        @Test
        public void falseTrueFalseTest() {
            assertEquals("Well that might be true", testClass.truthFinder(false, true, false));
        }

        @Test
        public void trueFalseFalseTest() {
            assertEquals("Well that might be true", testClass.truthFinder(true, false, false));
        }

        @Test
        public void falseFalseFalseTest() {
            assertEquals("Are you even trying to find the truth?", testClass.truthFinder(false, false, false));
        }

        @Test
        public void trueTrueTrueTest() {
            assertEquals("YOU FOUND THE TRUTH!", testClass.truthFinder(true, true, true));
        }

        @Test
        public void falseFalseTrueTest() {
            assertEquals("Are you even trying to find the truth?", testClass.truthFinder(false, false, true));
        }
    }
}