package hw4;

import hw4.base.TestBase;
import hw4.pageObjects.DatesPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.DifferentElements.FROM_SLIDER;
import static hw4.enums.DifferentElements.TO_SLIDER;
import static hw4.enums.Users.PITER_CHAILOVSKII;

public class DatesPageTestSelenide extends TestBase {
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        datesPage = page(DatesPage.class);
    }


    @Test
    public void datesPageSlidersTest() {

        //1 Open test site by URL
        datesPage.openPage();

        //2 Assert Browser title
        datesPage.checkTitle();

        //3 Perform login
        datesPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        datesPage.checkUserName(PITER_CHAILOVSKII.fullName);

        //5 Open through the header menu Service -> Dates Page
        datesPage.openServiceHeader();
        datesPage.openCategory("Dates");

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRow(String.format(FROM_SLIDER.logText, 0));
        datesPage.checkLogRow(String.format(TO_SLIDER.logText, 100));

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.setRange(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRow(String.format(FROM_SLIDER.logText, 0));
        datesPage.checkLogRow(String.format(TO_SLIDER.logText, 0));

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setRange(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRow(String.format(FROM_SLIDER.logText, 100));
        datesPage.checkLogRow(String.format(TO_SLIDER.logText, 100));

        //12 Using drag-and-drop set Range sliders.
        datesPage.setRange(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRow(String.format(FROM_SLIDER.logText, 30));
        datesPage.checkLogRow(String.format(TO_SLIDER.logText, 70));
    }
}
