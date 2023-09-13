package Day07;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _02_SoftAssertvsHardAssert {

    @Test
    void hardAssertTest() {

        String name = "John";

        System.out.println("Before Assertion");

        Assert.assertTrue(name.equals("George")); // Hard Assert: if expected and actual are different
        // it throws an exception and stops running the rest of the test
        // Then TestNG starts running the next test method

        System.out.println("After Assertion");
    }

    @Test
    void softAssertTest(){
        String name = "John";

        System.out.println("Before Assertion");

        SoftAssert softAssert = new SoftAssert();
        // SoftAssert: If expected and actual results are different soft assert doesn't stop the execution of the code
        // it saves the errors in the memory until we use assertAll method.

        softAssert.assertTrue(name.equals("George"));

        System.out.println("After Assertion");

        softAssert.assertAll();
    }

    // if the rest of the test depends on the value you are testing use hard assert because the rest of the code will not run correctly without that value
    // If the value you are testing is not important for the rest of the test use soft assert
}
