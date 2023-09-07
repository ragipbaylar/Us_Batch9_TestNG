package Day04;

import org.testng.annotations.*;

public class _01_XMLIntro {

    // Before Method, After Method, Before Class and After Class are class level annotations.
    // They don't have any effect on other classes

    // Before Suit, After Suit, Before Test, After Test, Before Group and After Group are high level annotations.
    // They can effect all classes in the classes tags


    //@BeforeSuit Runs before each suit
        //@BeforeTest Runs before each test
            //BeforeGroup Runs before each group
                //@BeforeClass Runs before everything in the class
                    //@BeforeMethod Runs before each test method
                        //@Test we write our test methods
                        //@Test
                    //@AfterMethod Runs after each test method
                //@AfterClass Runs after everything in the class
            //@AfterGroup Runs after each group
        //@AfterTest Runs after each group
    //@AfterSuit Runs after each suit
    @BeforeSuite
    void beforeSuit(){
        System.out.println("Before Suit is running");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test is running");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class is running");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method is running");
    }

    @Test
    void test1(){
        System.out.println("Test 1 from class 1 is running");
    }

    @Test
    void test2(){
        System.out.println("Test 2 from class 1 is running");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After Method is running");
    }

    @AfterClass
    void afterClass(){
        System.out.println("After Class is running");
    }

    @AfterTest
    void afterTest(){
        System.out.println("After Test is running");
    }

    @AfterSuite
    void afterSuit(){
        System.out.println("After Suit is running");
    }
}
