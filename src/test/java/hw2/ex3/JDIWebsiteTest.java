package hw2.ex3;

import hw2.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class JDIWebsiteTest extends TestBase {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @BeforeMethod
    public void beforeTest() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterTest() {
        System.out.println(driver.getTitle());
    }

    @Test
    public void homePageContentTest() {

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userNameSpan = driver.findElement(By.cssSelector(".profile-photo [ui='label']"));
        assertEquals(userNameSpan.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = driver.findElements(By.cssSelector(".uui-navigation.m-l8 > li > a"));
        assertEquals(headerItems.size(), 4);
        headerItems.forEach(x -> assertTrue(x.isDisplayed()));
        assertEquals(headerItems.get(0).getText(), "HOME");
        assertEquals(headerItems.get(1).getText(), "CONTACT FORM");
        assertEquals(headerItems.get(2).getText(), "SERVICE");
        assertEquals(headerItems.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        images.forEach(x -> assertTrue(x.isDisplayed()));

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(iconTexts.size(), 4);
        iconTexts.forEach(x -> assertTrue(x.isDisplayed()));
        assertEquals(iconTexts.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(iconTexts.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(iconTexts.get(2).getText(), "To be multiplatform");
        assertEquals(iconTexts.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main header
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title"));
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement header = driver.findElement(By.cssSelector("p.main-txt"));
        assertEquals(header.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id = 'iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement logo = driver.findElement(By.cssSelector("[id = 'epam_logo']"));
        assertTrue(logo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center [target = '_blank']"));
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".uui-side-bar"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector(".footer-content.overflow"));
        assertTrue(footer.isDisplayed());

    }
}
