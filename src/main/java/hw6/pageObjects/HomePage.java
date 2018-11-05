package hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.enums.ServiceCategories;
import hw6.enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hw6.enums.Headers.TITLE;
import static hw6.enums.Links.HOME_PAGE;

public class HomePage {

    public HomePage() {
        page(this);
    }

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

    @FindBy(css = ".benefit-icon")
    private ElementsCollection images;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection imageTexts;

    @FindBy(css = "h3.main-title")
    private SelenideElement headline;

    @FindBy(css = "p.main-txt")
    private SelenideElement description;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement serviceHeader;

    @FindBy(xpath = "//li[@class='menu-title'][@index='3']/a")
    private SelenideElement serviceLeftSection;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection serviceHeaderOptions;

    @FindBy(xpath = "//li[@class='menu-title'][@index='3']/ul/li")
    private ElementsCollection serviceLeftSectionOptions;

    //===============================methods==========================================

    @Given("I am on \"Home Page\"")
    public void openPage() {
        open(HOME_PAGE.link);
    }

    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @When("I login as user \"(.+)\"")
    public void login(String userName) {
        login(Users.valueOf(userName.replaceAll(" ", "_").toUpperCase()));
    }

    @When("I click on \"Service\" button in Header")
    public void openServiceHeader() {
        serviceHeader.click();
    }

    @When("I click on \"Service\" subcategory in the left section")
    public void openServiceLeftSection() {
        serviceLeftSection.click();
    }

    public void openCategory(ServiceCategories serviceCategory) {
        serviceHeaderOptions.find(text(serviceCategory.categoryName.toUpperCase())).click();
    }

    @Given("I click on \"(.+)\" button in Service dropdown")
    public void openCategory(String serviceCategory) {
        openCategory(ServiceCategories.valueOf(serviceCategory.replaceAll(" ", "_").toUpperCase()));
    }

    //===============================checks==========================================

    @Then("The browser title is Home Page")
    public void checkTitle() {
        title.shouldHave(attribute("text", TITLE.text));
    }

    @Then("Name is displayed and equals to \"(.+)\"'s name")
    public void checkUserName(Users user) {
        userNameSpan.shouldHave(text(user.fullName.toUpperCase()));
    }

    @Then("4 pictures are displayed on the page")
    public void checkImages() {
        images.forEach(x -> x.shouldBe(visible));
    }

    @Then("4 texts are displayed under pictures")
    public void checkImageHeaders() {
        imageTexts.forEach(x -> x.shouldBe(visible));
    }

    @Then("2 texts - headline and description - are displayed above pictures")
    public void checkHeaders() {
        headline.shouldBe(visible);
        description.shouldBe(visible);
    }

    @Then("Dropdown contains following options:")
    public void checkServiceHeaderOptions(List<String> categories) {
        for (String header : categories) {
            serviceHeaderOptions.find(text(header.toUpperCase())).shouldBe(exist);
        }
    }

    @Then("Dropdown of left section contains following options:")
    public void checkServiceLeftSectionOptions(List<String> categories) {
        for (String header : categories) {
            serviceLeftSectionOptions.find(text(header.toUpperCase())).shouldBe(exist);
        }
    }
}
