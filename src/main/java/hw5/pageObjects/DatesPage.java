package hw5.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw5.enums.Logs.TO_SLIDER;
import static hw5.enums.Logs.FROM_SLIDER;

public class DatesPage {

    @FindBy(css = ".uui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(css = ".info-panel-body-log .info-panel-section > ul > li")
    private ElementsCollection logs;


    //===============================methods==========================================

    @Step
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

    @Step
    public void checkLogRows(int left, int right) {
        logs.first(2).findBy(text(String.format(TO_SLIDER.text, right))).shouldBe(exist);
        logs.first(2).findBy(text(String.format(FROM_SLIDER.text, left))).shouldBe(exist);
    }
}
