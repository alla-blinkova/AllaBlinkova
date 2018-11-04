package hw5.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw5.enums.CheckBoxes;
import hw5.enums.DropdownElements;
import hw5.enums.Logs;
import hw5.enums.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage {

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

    @Step
    public void selectCheckbox(CheckBoxes... checkBoxes) {
        Arrays.stream(checkBoxes).forEach(x -> this.checkBoxes.find(text(x.text)).click());
    }

    @Step
    public void selectRadioButton(RadioButtons radioButton) {
        radioButtons.find(text(radioButton.text)).click();
    }

    @Step
    public void selectInDropDown(DropdownElements dropdownElement) {
        dropdown.selectOptionContainingText(dropdownElement.text);
    }

    //===============================checks==========================================

    @Step
    public void checkElements() {
        checkBoxes.shouldHaveSize(4);
        checkBoxes.forEach(x -> x.shouldBe(visible));
        radioButtons.shouldHaveSize(4);
        radioButtons.forEach(x -> x.shouldBe(visible));
        dropdown.shouldBe(visible);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    @Step
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step
    public void checkLogRow(Logs log, Object... args) {
        logs.find(text(String.format(log.text, args))).shouldBe(exist);
    }
}
