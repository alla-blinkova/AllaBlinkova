package hw4.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}
