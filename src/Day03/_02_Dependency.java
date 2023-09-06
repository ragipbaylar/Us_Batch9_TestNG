package Day03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Dependency {
    // priority vs dependency
    // priority puts the test in a specific order and runs the next test whether or not the previous test is successful
    // dependency runs the tests in the dependent order and if the previous test fails it doesn't run the next test.
    // If a test depends on a test and that test also depends on another test,
    // all tests in the chain must be added to the dependencies of the last test

    @Test
    void startCar() {
        System.out.println("Car is started");
        //Assert.fail();
    }

    @Test(dependsOnMethods = "startCar")
        // This test depends on the success of startCar test
    void driveCar() {
        System.out.println("Car is being driven");
        //Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
        // This test depends on the success of both startCar and driveCar tests
    void parkCar() {
        System.out.println("The car is parked");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar", "parkCar"})
    void stopCar() {
        System.out.println("The car is stopped");
    }
}
