package Day04;

import org.testng.annotations.Test;

public class _03_Groups {

    @Test(groups = "Smoke")
    void test1(){
        System.out.println("Test 1 is running");
    }

    @Test(groups = "Regression")
    void test2(){
        System.out.println("Test 2 is running");
    }

    @Test(groups = "Regression")
    void test3(){
        System.out.println("Test 3 is running");
    }

    @Test(groups = "Smoke")
    void test4(){
        System.out.println("Test 4 is running");
    }

    @Test(groups = {"Smoke", "Regression"})
    void test5(){
        System.out.println("Test 5 is running");
    }
}
