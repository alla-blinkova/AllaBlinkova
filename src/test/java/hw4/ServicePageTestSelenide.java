package hw4;

import hw4.base.TestBase;
import hw4.pageObjects.ServicePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.DifferentElements.CHECKBOX;
import static hw4.enums.DifferentElements.DROPDOWN;
import static hw4.enums.DifferentElements.RADIOBUTTON;
import static hw4.enums.Users.PITER_CHAILOVSKII;

public class ServicePageTestSelenide extends TestBase {
    private ServicePage servicePage;

    @BeforeClass
    public void beforeClass() {
        servicePage = page(ServicePage.class);
    }

    @Test
    public void servicePageTest() {

        //1 Open test site by URL
        servicePage.openPage();

        //2 Assert Browser title
        servicePage.checkTitle();

        //3 Perform login
        servicePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserName(PITER_CHAILOVSKII.fullName);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.openServiceHeader();
        servicePage.checkServiceHeaderOptions();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePage.openServiceLeftSection();
        servicePage.checkServiceLeftSectionOptions();

        //7 Open through the header menu Service -> Different Elements Page
        servicePage.openCategory("Different Elements");

        //8 Check interface on Different elements page, it contains all needed elements
        servicePage.checkDifferentElements();

        //9 Assert that there is Right Section
        servicePage.checkRightSection();

        //10 Assert that there is Left Section
        servicePage.checkLeftSection();

        //11 Select checkboxes
        servicePage.selectCheckbox("Water");
        servicePage.selectCheckbox("Wind");

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkLogRow(String.format(CHECKBOX.logText, "Water", true));
        servicePage.checkLogRow(String.format(CHECKBOX.logText, "Wind", true));

        //13 Select radio
        servicePage.selectRadioButton("Selen");

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        servicePage.checkLogRow(RADIOBUTTON.logText + "Selen");

        //15 Select in dropdown
        servicePage.selectInDropDown("Yellow");

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        servicePage.checkLogRow(DROPDOWN.logText + "Yellow");

        //17 Unselect and assert checkboxes
        servicePage.selectCheckbox("Water");
        servicePage.selectCheckbox("Wind");

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        servicePage.checkLogRow(String.format(CHECKBOX.logText, "Water", false));
        servicePage.checkLogRow(String.format(CHECKBOX.logText, "Wind", false));
    }
}
