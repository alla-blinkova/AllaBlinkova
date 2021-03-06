package hw5;

import hw5.base.TestBase;
import hw5.listeners.AllureAttachmentListener;
import hw5.pageObjects.DatesPage;
import hw5.pageObjects.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw5.enums.ServiceCategories.DATES;
import static hw5.enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Dates page testing")
@Listeners(AllureAttachmentListener.class)
public class DatesPageTestSelenide extends TestBase {
    private HomePage homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        datesPage = page(DatesPage.class);
        getWebDriver().manage().window().maximize();
    }


    @Test
    public void datesPageSlidersTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkUserName(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        homePage.openServiceHeader();
        homePage.openCategory(DATES);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRows(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.setRange(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRows(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setRange(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRows(100, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.setRange(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRows(30, 70);
    }
}
