package mobile.hw2.scenarios.nativetests;

import mobile.hw2.setup.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "native")
public class SimpleNativeTests extends Driver {
    protected SimpleNativeTests() {
        super();
    }

    @Test(groups = "native")
    public void SimplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        //1 Check contact name
        WebElement contactName = driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Contact Name\"]"));
        WebElement contactNameField = driver().findElement(By.id(app_package_name + "contactNameEditText"));
        assertEquals(contactName.getText(), "Contact Name");
        assertTrue(contactNameField.isDisplayed());

        //2 Check contact phone
        WebElement contactPhone = driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Contact Phone\"]"));
        WebElement contactPhoneField = driver().findElement(By.id(app_package_name + "contactPhoneEditText"));
        assertEquals(contactPhone.getText(), "Contact Phone");
        assertTrue(contactPhoneField.isDisplayed());

        System.out.println("Simplest Appium test done");
    }
}
