package Day07;

import Utilities.DriverClass;
import org.testng.annotations.Test;


public class _05_PlaceOrderWithPOM extends DriverClass {

    @Test
    void placeOrderTest(){

        _04_PlaceOrderElements elements = new _04_PlaceOrderElements();
        elements.searchInput.sendKeys("ipod");
        elements.searchButton.click();




    }
}
