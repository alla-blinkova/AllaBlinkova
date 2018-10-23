package hw4.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw4.enums.Headers.TITLE;
import static hw4.enums.Links.HOME_PAGE;

public class DatesPage {

    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".profile-photo [ui='label']")
    private SelenideElement userNameSpan;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement serviceHeader;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection serviceHeaderOptions;

    @FindBy(css = ".uui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(css = ".info-panel-body-log .info-panel-section > ul > li")
    private ElementsCollection logs;


    //===============================methods==========================================

    public void openPage() {
        open(HOME_PAGE.link);
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void openServiceHeader() {
        serviceHeader.click();
    }

    public void openCategory(String category) {
        serviceHeaderOptions.find(text(category.toUpperCase())).click();
    }

    public void setRange(int left, int right) {

        int currentLeft = Integer.parseInt(sliders.get(0).text());
        int currentRight = Integer.parseInt(sliders.get(1).text());

        if (left > currentRight) {
            moveSlider(sliders.get(1), right, currentRight);
            moveSlider(sliders.get(0), left, currentLeft);
        } else {
            moveSlider(sliders.get(0), left, currentLeft);
            moveSlider(sliders.get(1), right, currentRight);
        }
    }

    private void moveSlider(SelenideElement sliderHandle, int target, int current) {
        double width = slider.getSize().width;
        Actions action = new Actions(getWebDriver());
        action.dragAndDropBy(sliderHandle, (int) ((Math.round((width * (target - current)) / 100)) - 1), 0).build().perform();
    }

    //===============================checks==========================================

    public void checkTitle() {
        title.shouldHave(attribute("text", TITLE.text));
    }

    public void checkUserName(String name) {
        userNameSpan.shouldHave(text(name.toUpperCase()));
    }

    public void checkLogRow(String row) {
        logs.first(2).find(text(row)).shouldBe(exist);
    }
}
