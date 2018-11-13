package mobile.hw3.scenarios.nativetests;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.hw3.pageObjects.ContactManagerPage;
import mobile.hw3.setup.Driver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = "native")
public class SimpleNativeTests extends Driver {
    protected SimpleNativeTests() {
        super();
    }

    private ContactManagerPage contactManagerPage = new ContactManagerPage();

    @BeforeMethod
    public void beforeMethod() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(driver()), contactManagerPage);
    }

    @Test(groups = "native")
    public void SimplestTest() {

        contactManagerPage.addContact();

        //1 Check contact name
        contactManagerPage.checkContactName();
        contactManagerPage.checkContactNameField();

        //2 Check contact phone
        contactManagerPage.checkContactPhone();
        contactManagerPage.checkContactPhoneField();

        System.out.println("Simplest Appium test done");
    }
}
