package Day01;

import org.testng.annotations.Test;

public class _01_Intro {

//    public static void main(String[] args) {
//        go to the page
//        login
//        add to cart
//        check out
//    }

//    @Test -> from JUnit
//    public void test1(){
//        go to the page
//        login
//        add to cart
//        check out
//    }

    // priority -> we can put the test in the order we want. Without priority it runs the tests in alphabetical order
    @Test(priority = 1)
    public void loginTest(){
        System.out.println("Login test is successful");
    }

    @Test(priority = 2)
    public void addToCartTest(){
        System.out.println("Add to cart test is successful");
    }

    @Test(priority = 3)
    public void checkOutTest(){
        System.out.println("Check out test is successful");
    }
}
