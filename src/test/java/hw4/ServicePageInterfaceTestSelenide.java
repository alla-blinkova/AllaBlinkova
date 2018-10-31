package hw4;

import hw4.base.TestBase;
import hw4.pageObjects.DifferentElementsPage;
import hw4.pageObjects.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.CheckBoxes.*;
import static hw4.enums.DropdownElements.*;
import static hw4.enums.Logs.CHECKBOX;
import static hw4.enums.Logs.DROPDOWN;
import static hw4.enums.Logs.RADIOBUTTON;
import static hw4.enums.RadioButtons.*;
import static hw4.enums.ServiceCategories.*;
import static hw4.enums.Users.PITER_CHAILOVSKII;

public class ServicePageInterfaceTestSelenide extends TestBase {
    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void servicePageInterfaceTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is loggined
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
        differentElementsPage.selectInDropDown(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.checkLogRow(DROPDOWN, YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckbox(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLogRow(CHECKBOX, WATER, false);
        differentElementsPage.checkLogRow(CHECKBOX, WIND, false);
    }
}
