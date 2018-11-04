package hw5.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw5.enums.ServiceCategories;
import hw5.enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static hw5.enums.Headers.TITLE;
import static hw5.enums.Links.HOME_PAGE;

public class HomePage {
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

    //===============================methods==========================================

    @Step
    public void openPage() {
        open(HOME_PAGE.link);
    }

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    public void openServiceHeader() {
        serviceHeader.click();
    }

    @Step
    public void openServiceLeftSection() {
        serviceLeftSection.click();
    }

    @Step
    public void openCategory(ServiceCategories serviceCategory) {
        serviceHeaderOptions.find(text(serviceCategory.categoryName.toUpperCase())).click();
    }

    //===============================checks==========================================

    @Step
    public void checkTitle() {
        title.shouldHave(attribute("text", TITLE.text));
    }

    @Step
    public void checkUserName(Users user) {
        userNameSpan.shouldHave(text(user.fullName.toUpperCase()));
    }

    @Step
    public void checkServiceHeaderOptions() {
        for (String header : ServiceCategories.getCategories()) {
            serviceHeaderOptions.find(text(header.toUpperCase())).shouldBe(exist);
        }
    }

    @Step
    public void checkServiceLeftSectionOptions() {
        for (String header : ServiceCategories.getCategories()) {
            serviceLeftSectionOptions.find(text(header.toUpperCase())).shouldBe(exist);
        }
    }
}
