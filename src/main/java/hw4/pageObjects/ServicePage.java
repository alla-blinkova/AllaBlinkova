package hw4.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Headers;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import static hw4.enums.Headers.TITLE;
import static hw4.enums.Links.HOME_PAGE;

public class ServicePage {

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

    @FindBy(xpath = "//li[@class='menu-title'][@index='3']/a")
    private SelenideElement serviceLeftSection;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection serviceHeaderOptions;

    @FindBy(xpath = "//li[@class='menu-title'][@index='3']/ul/li")
    private ElementsCollection serviceLeftSectionOptions;

    @FindBy(css = "[name = 'navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "[name = 'log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors > select")
    private SelenideElement dropDown;

    @FindBy(css = "[name = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value = 'Button']")
    private SelenideElement button;

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

    public void openServiceLeftSection() {
        serviceLeftSection.click();
    }

    public void openCategory(String category) {
        serviceLeftSectionOptions.find(text(category.toUpperCase())).click();
    }

    public void selectCheckbox(String name) {
        checkboxes.find(text(name)).click();
    }

    public void selectRadioButton(String name) {
        radioButtons.find(text(name)).click();
    }

    public void selectInDropDown(String name) {
        dropDown.selectOptionContainingText(name);
    }

    //===============================checks==========================================

    public void checkTitle() {
        title.shouldHave(attribute("text", TITLE.text));
    }

    public void checkUserName(String name) {
        userNameSpan.shouldHave(text(name.toUpperCase()));
    }

    public void checkServiceHeaderOptions() {
        for (String header : Headers.getServiceCategories()) {
            serviceHeaderOptions.find(text(header.toUpperCase())).shouldBe(exist);
        }
    }


    public void checkServiceLeftSectionOptions() {
        for (String header : Headers.getServiceCategories()) {
            serviceLeftSectionOptions.find(text(header.toUpperCase())).shouldBe(exist);
        }
    }

    public void checkDifferentElements() {
        checkboxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropDown.shouldBe(visible);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLogRow(String row) {
        logs.find(text(row)).shouldBe(exist);
    }
}
