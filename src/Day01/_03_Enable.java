package Day01;

import org.testng.annotations.Test;

public class _03_Enable {

    // if you use enabled=false TestNG will skip that test and run the others
    // enabled=true is the default value. So you don't need to use it if you want a test to be run

    @Test(enabled = false,priority = 1)
    void test1(){
        System.out.println("Test 1 is successful");
    }

    @Test(enabled = true)
    void test2(){
        System.out.println("Test 2 is successful");
    }

    @Test()
    void test3(){
        System.out.println("Test 3 is successful");
    }
}
