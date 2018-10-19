package hw3.pageObjects;

import hw3.enums.Headers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw3.enums.Headers.*;
import static hw3.enums.Links.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = ".profile-photo [ui='label']")
    private WebElement userNameSpan;

    @FindBy(css = ".m-l8 > li > a")
    private List<WebElement> headerItems;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> iconTexts;

    @FindBy(css = "h3.main-title")
    private WebElement mainHeader;

    @FindBy(css = "p.main-txt")
    private WebElement header;

    @FindBy(css = "[id = 'iframe']")
    private WebElement iFrame;

    @FindBy(css = "[id = 'epam_logo']")
    private WebElement logo;

    @FindBy(css = "h3.text-center > a")
    private WebElement subHeader;

    @FindBy(css = ".uui-side-bar")
    private WebElement leftSection;

    @FindBy(css = ".footer-content.overflow")
    private WebElement footer;

    //===============================methods==========================================

    public void open(WebDriver driver) {
        driver.navigate().to(HOME_PAGE.link);
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void switchToIFrame(WebDriver driver) {
        driver.switchTo().frame(iFrame);
    }

    public void switchToWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //===============================checks==========================================

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(),TITLE.text);
    }

    public void checkUserName(String name) {
        assertEquals(userNameSpan.getText(), name.toUpperCase());
    }

    public void checkHeaderItems() {
        assertEquals(headerItems.size(), 4);
        headerItems.forEach(x -> assertTrue(x.isDisplayed()));
        headerItems.forEach(x -> assertTrue(Headers.getMenuHeaders().contains(x.getText())));
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        images.forEach(x -> assertTrue(x.isDisplayed()));
    }

    public void checkIconTexts() {
        assertEquals(iconTexts.size(), 4);
        iconTexts.forEach(x -> assertTrue(x.isDisplayed()));
        iconTexts.forEach(x -> assertTrue(Headers.getIconHeaders().contains(x.getText())));
    }

    public void checkMainHeader() {
        assertEquals(mainHeader.getText(), MAIN_HEADER.text);
    }

    public void checkSecondaryHeader() {
        assertEquals(header.getText(), SECONDARY_HEADER.text);
    }

    public void checkIFrameIsDisplayed() {
        assertTrue(iFrame.isDisplayed());
    }

    public void checkLogoIsDisplayed() {
        assertTrue(logo.isDisplayed());
    }

    public void checkSubHeader() {
        assertEquals(subHeader.getText(), SUB_HEADER.text);
    }

    public void checkSubHeaderLink() {
        assertEquals(subHeader.getAttribute("href"), GITHUB.link);
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}