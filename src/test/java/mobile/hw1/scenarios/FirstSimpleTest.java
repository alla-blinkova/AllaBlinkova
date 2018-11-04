package mobile.hw1.scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {
    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareNative();
        //prepareAndroidWeb();
        //prepareNativeRealDevice();
        //prepareAndroidWeb();
    }

    @Test
    /**
     * This simple test just click on button 'Add contact' found by id
     */
    public void SimplestTest(){
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    @Test
    /**
     * This simple test just click on button 'Add contact' found by xpath
     */
    public void SimplestTestXpath(){
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    @Test
    /**
     * This simple test just click on button 'Add contact' found by classname
     */
    public void SimplestTestClassname(){
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.className("android.widget.Button");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() throws Exception {
        driver.quit();
    }

}
