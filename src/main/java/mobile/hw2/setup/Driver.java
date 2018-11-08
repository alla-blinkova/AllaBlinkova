package mobile.hw2.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mobile.hw2.enums.PropertyFiles;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Initialize a driver with test properties
 */
public class Driver extends TestProperties {

    private static AppiumDriver driverSingle;
    private static WebDriverWait waitSingle;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected static String AUT; //(mobile) app under testing
    protected static String SUT; // site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;

    protected Driver() {
    }

    protected void initProperties(PropertyFiles file) throws IOException {
        getCurrentProps(file);
        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application      * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //default Android emulator
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);

        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }

}
