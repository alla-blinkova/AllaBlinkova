package hw4.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.CheckBoxes;
import hw4.enums.DropdownElements;
import hw4.enums.Logs;
import hw4.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;

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

    public void selectCheckbox(CheckBoxes... checkBoxes) {
        Arrays.stream(checkBoxes).forEach(x -> this.checkBoxes.find(text(x.text)).click());
    }

    public void selectRadioButton(RadioButtons radioButton) {
        radioButtons.find(text(radioButton.text)).click();
    }

    public void selectInDropDown(DropdownElements dropdownElement) {
        dropdown.selectOptionContainingText(dropdownElement.text);
    }

    //===============================checks==========================================

    public void checkElements() {
        checkBoxes.shouldHaveSize(4);
        checkBoxes.forEach(x -> x.shouldBe(visible));
        radioButtons.shouldHaveSize(4);
        radioButtons.forEach(x -> x.shouldBe(visible));
        dropdown.shouldBe(visible);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLogRow(Logs log, Object... args) {
        logs.find(text(String.format(log.text, args))).shouldBe(exist);
    }
}
