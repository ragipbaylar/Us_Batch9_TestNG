package Day06;

import org.testng.annotations.Test;

public class _03_DataProviderFromDifferentClass {

    @Test(dataProvider = "credentialsMethod", dataProviderClass = _02_DataProvider.class)
    void test1(String username, String password){
        System.out.println(username+" "+password);
    }
}
