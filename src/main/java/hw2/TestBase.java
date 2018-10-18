package hw2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class TestBase {

    private String driverPath = "src\\main\\resources\\chromedriver.exe";

    @BeforeSuite()
    public void beforeSuit() {
        setProperty("webdriver.chrome.driver", driverPath);
    }

    @AfterSuite()
    public void afterSuit() {
        System.out.println(System.currentTimeMillis());
    }
}
