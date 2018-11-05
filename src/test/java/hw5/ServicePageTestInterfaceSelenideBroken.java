package hw5;

import hw5.base.TestBase;
import hw5.listeners.AllureAttachmentListener;
import hw5.pageObjects.DifferentElementsPage;
import hw5.pageObjects.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw5.enums.CheckBoxes.WATER;
import static hw5.enums.CheckBoxes.WIND;
import static hw5.enums.DropdownElements.GREEN;
import static hw5.enums.DropdownElements.YELLOW;
import static hw5.enums.Logs.CHECKBOX;
import static hw5.enums.Logs.DROPDOWN;
import static hw5.enums.Logs.RADIOBUTTON;
import static hw5.enums.RadioButtons.SELEN;
import static hw5.enums.ServiceCategories.DIFFERENT_ELEMENTS;
import static hw5.enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Service page testing broken")
@Listeners(AllureAttachmentListener.class)
public class ServicePageTestInterfaceSelenideBroken extends TestBase {
    private DifferentElementsPage differentElementsPage;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        differentElementsPage = page(DifferentElementsPage.class);
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void servicePageInterfaceTestBroken() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkUserName(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.openServiceHeader();
        homePage.checkServiceHeaderOptions();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.openServiceLeftSection();
        homePage.checkServiceLeftSectionOptions();

        //7 Open through the header menu Service -> Different Elements Page
        homePage.openServiceHeader();
        homePage.openCategory(DIFFERENT_ELEMENTS);

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkElements();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSection();

        //11 Select checkboxes
        differentElementsPage.selectCheckbox(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogRow(CHECKBOX, WATER, true);
        differentElementsPage.checkLogRow(CHECKBOX, WIND, true);

        //13 Select radio
        differentElementsPage.selectRadioButton(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLogRow(RADIOBUTTON, SELEN);

        //15 Select in dropdown
        differentElementsPage.selectInDropDown(GREEN);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.checkLogRow(DROPDOWN, YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckbox(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLogRow(CHECKBOX, WATER, false);
        differentElementsPage.checkLogRow(CHECKBOX, WIND, false);
    }

}
