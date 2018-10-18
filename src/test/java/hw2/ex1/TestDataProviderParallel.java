package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestDataProviderParallel {

    @DataProvider(parallel = true)
    public Object[][] dataProvider() {
        return new Object[][] {
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void textUnderIconTest(int i, String header) {

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert that there is text on the Index Page under icon and it has proper text
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(iconTexts.size(), 4);
        assertTrue(iconTexts.get(i).isDisplayed());
        assertEquals(iconTexts.get(i).getText(), header);

        //3 Close Browser
        driver.close();
    }
}
