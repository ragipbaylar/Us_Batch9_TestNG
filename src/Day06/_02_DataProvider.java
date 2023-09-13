package Day06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {
    @Test(dataProvider = "credentials")
    void login(String username, String password) {
        System.out.println("Test is started");
        System.out.println(username + " " + password);
        System.out.println("Test is ended");
    }

    @Test(dataProvider = "credentialsMethod")
    void login1(String username, String password) {
        System.out.println("Test is started");
        System.out.println(username + " " + password);
        System.out.println("Test is ended");
    }

    @DataProvider()
    public Object[][] credentials() {
        Object[][] dataList = {
                {"John", "qwerty"},
                {"John123", "qwert12345"},
                {"1234John", "1234567qwerty"},
                {"12John345", "12qwerty345"}
        };
        return dataList;
    }

    @DataProvider(name = "credentialsMethod")
    public Object[][] credentials1() {
        Object[][] dataList = {
                {"John", "qwerty"},
                {"John123", "qwert12345"},
                {"1234John", "1234567qwerty"},
                {"12John345", "12qwerty345"}
        };
        return dataList;
    }

}
