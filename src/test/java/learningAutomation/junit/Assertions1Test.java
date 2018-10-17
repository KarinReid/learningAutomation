package learningAutomation.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class Assertions1Test {

    @Test
    public void myEqualsAssertionTest () {

        assertEquals("Three plus three equals 6", (3+3), 6);
        assertEquals("True == True", true, true);

        String myAge = "Twenty One";
        assertEquals("My age is equal to 21", "Twenty One", myAge);
    }


    @Test
    public void myTrueAssertionTest () {

        assertTrue("True is true", true);
        assertTrue("Three plus three equals 6", (3+3)==6);

        String myName = "Karin";
        assertTrue("My name is Karin", "karin".equalsIgnoreCase("karin"));
    }

    @Test
    public void myFalseAssertionTest () {

        assertFalse("False is false", false);
        assertFalse("False is false", !true);

        String myString = "holy moly";
        assertFalse("Does not contain the", myString.contains("the"));
    }
}
