package hw6.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@CucumberOptions(features = "src/test/java/hw6", glue = "hw6.pageObjects")
public class ServicePageInterfaceTestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }

    @BeforeMethod
    public void beforeMethod() {
        getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }
}
