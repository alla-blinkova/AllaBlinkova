package hw4.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        getWebDriver().manage().window().maximize();
    }
}
