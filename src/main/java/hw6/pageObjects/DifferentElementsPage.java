package hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.enums.CheckBoxes;
import hw6.enums.DropdownElements;
import hw6.enums.Logs;
import hw6.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPage {

    public DifferentElementsPage() {
        page(this);
    }

    @FindBy(css = "[name = 'navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "[name = 'log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors > select")
    private SelenideElement dropdown;

    @FindBy(css = "[name = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value = 'Button']")
    private SelenideElement button;

    @FindBy(css = ".info-panel-body-log .info-panel-section > ul > li")
    private ElementsCollection logs;

    //===============================methods==========================================

    @When("I click on \"(.+)\" checkboxes")
    public void selectCheckbox(List<CheckBoxes> checkBoxes) {
        checkBoxes.forEach(x -> this.checkBoxes.find(text(x.text)).click());
    }

    @When("I select \"(.+)\" radiobutton")
    public void selectRadioButton(RadioButtons radioButton) {
        radioButtons.find(text(radioButton.text)).click();
    }

    @When("I select \"(.+)\" in dropdown")
    public void selectInDropDown(DropdownElements dropdownElement) {
        dropdown.selectOptionContainingText(dropdownElement.text);
    }

    //===============================checks==========================================

    @Then("4 checkboxes, 4 radios, 1 dropdown, 2 buttons are displayed")
    public void checkElements() {
        checkBoxes.shouldHaveSize(4);
        checkBoxes.forEach(x -> x.shouldBe(visible));
        radioButtons.shouldHaveSize(4);
        radioButtons.forEach(x -> x.shouldBe(visible));
        dropdown.shouldBe(visible);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    @Then("Left section is displayed")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Then("Right section is displayed")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Then("Log row for (.+) is displayed. Name of element and status \\(for checkboxes\\): (.+)")
    public void checkLogRow(Logs log, List<Object> args) {
        logs.find(text(String.format(log.text, args.toArray()))).shouldBe(exist);
    }

}
