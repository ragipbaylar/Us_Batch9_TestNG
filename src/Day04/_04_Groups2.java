package Day04;

import org.testng.annotations.Test;

public class _04_Groups2 {

    @Test(groups = "Smoke")
    void test1(){
        System.out.println("Test 1 from 2 is running");
    }

    @Test(groups = "Regression")
    void test2(){
        System.out.println("Test 2 from 2 is running");
    }
}
