package Day02;

import io.netty.util.AsciiString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Assertions {

    @Test
    void test1(){
        String str1 = "John";
        String str2 = "John";

        // Checks if actual and expected are the same. If they are not the same it throws an exception
        // then prints the message
        Assert.assertEquals(str1,str2,"Test is not successful");
    }

    @Test
    void test2(){
        String str1 = "John";
        String str2 = "Snow";

        // Checks if actual and expected are the same. If they are not the same it throws an exception
        // then prints the message
        Assert.assertEquals(str1,str2,"Test is not successful");
    }

    @Test
    void test3(){
        int n1 = 5;
        int n2 = 6;

        // Checks if actual and expected are different. If they are not different test is not successful
        // It throws an exception and prints the message
        Assert.assertNotEquals(n1,n2 ,"Test is not successful");
    }

    @Test
    void test4(){
        int n1 = 5;
        int n2 = 5;

        // Checks if actual and expected are different. If they are not different test is not successful
        // It throws an exception and prints the message
        Assert.assertNotEquals(n1,n2 ,"Test is not successful");
    }

    @Test
    void test5(){
        int num1 = 14;
        int num2 = 14;

        // Checks the result of the condition is true. If it is not true throws an exception and prints the message
        Assert.assertTrue(num1==num2,"Test is not successful");
    }

    @Test
    void test6(){
        int num1 = 14;
        int num2 = 23;

        // Checks the result of the condition is false. If it is not true throws an exception and prints the message
        Assert.assertFalse(num1==num2,"Test is not successful");
    }

    @Test
    void test7(){
        String name = null;
        String name1 = "John";

        // Checks if the object is null. If it is not null throws an exception and prints the message
        Assert.assertNull(name,"Test is not successful");
        Assert.assertNull(name1,"Test is not successful");
    }

    @Test
    void test8(){
        // Fails anyways.
        Assert.fail("Test is not successful");
    }
}
