package mobile.hw3.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactManagerPage {

    private final String app_package_name = "com.example.android.contactmanager:id/";

    @FindBy(id = app_package_name + "addContactButton")
    private WebElement addButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Name\"]")
    private WebElement contactName;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Phone\"]")
    private WebElement contactPhone;

    @FindBy(id = app_package_name + "contactNameEditText")
    private WebElement contactNameField;

    @FindBy(id = app_package_name + "contactPhoneEditText")
    private WebElement contactPhoneField;

    public void addContact() {
        addButton.click();
    }

    public void checkContactName() {
        assertEquals(contactName.getText(), "Contact Name");
    }

    public void checkContactNameField() {
        assertTrue(contactNameField.isDisplayed());
    }

    public void checkContactPhone() {
        assertEquals(contactPhone.getText(), "Contact Phone");
    }

    public void checkContactPhoneField() {
        assertTrue(contactPhoneField.isDisplayed());
    }

}
