package hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.page;

public class UserTablePage {

    public UserTablePage() {
        page(this);
    }

    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = "select")
    private ElementsCollection dropdowns;

    @FindBy(css = ".main-content-hg a")
    private ElementsCollection numbers;

    @FindBy(css = ".main-content-hg a")
    private ElementsCollection names;

    @FindBy(css = ".main-content-hg img")
    private ElementsCollection images;

    @FindBy(css = ".user-descr")
    private ElementsCollection descriptions;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "#user-table")
    private SelenideElement table;

    @FindBy(css = ".info-panel-body-log .info-panel-section > ul > li")
    private ElementsCollection logs;

    private SelenideElement openedDropdown;

    //===============================methods==========================================

    @When("I select 'vip' checkbox for \"(.+)\"")
    public void selectCheckbox(String name) {
        SelenideElement row = names.find(text(name)).closest("tr");
        row.find(byText("Vip")).click();
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void openDropdown(String name) {
        SelenideElement row = names.find(text(name)).closest("tr");
        openedDropdown = row.find(byCssSelector("select"));
        openedDropdown.click();
    }

    //===============================checks==========================================

    @Then("(\\d) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkDropdowns(int count) {
        dropdowns.shouldHaveSize(count);
        dropdowns.forEach(x -> x.shouldBe(visible));
    }

    @Then("(\\d) User names are displayed on Users Table on User Table Page")
    public void checkNames(int count) {
        names.shouldHaveSize(6);
        names.forEach(x -> x.shouldBe(visible));
    }

    @Then("(\\d) Description images are displayed on Users Table on User Table Page")
    public void checkImages(int count) {
        images.shouldHaveSize(6);
        images.forEach(x -> x.shouldBe(visible));
    }

    @Then("(\\d) Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescrptions(int count) {
        descriptions.shouldHaveSize(6);
        descriptions.forEach(x -> x.shouldBe(visible));
    }

    @Then("(\\d) checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxes(int count) {
        checkboxes.shouldHaveSize(6);
        checkboxes.forEach(x -> x.shouldBe(visible));
    }

    @Then("1 log row has \"(.+)\" text in log section")
    public void checkLogRow(String log) {
        logs.first().shouldHave(text(log));
    }

    @Then("droplist contains values")
    public void checkDropdownValues(List<String> values) {
        Select select = new Select(openedDropdown);
        select.getOptions().stream()
                .map(WebElement::getText)
                .forEach(x -> Assert.assertTrue(values.contains(x)));
    }

    @Then("\"User Table\" page is opened")
    public void checkTitle() {
        title.shouldHave(attribute("text", "User Table"));
    }

    @Then("User table contains following values:")
    public void checkTableValues(DataTable values) {
        List<Map<String, String>> table = values.asMaps(String.class, String.class);
        for (int i = 0; i < table.size(); i++) {
            this.table.find(byText(table.get(i).get("Number"))).shouldBe(exist);
            names.get(i).shouldHave(text(table.get(i).get("User")));
            descriptions.get(i).shouldHave(text(table.get(i).get("Description")));
        }
    }
}
