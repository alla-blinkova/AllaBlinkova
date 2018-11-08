package mobile.hw2.scenarios.webtests;

import mobile.hw2.setup.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class SimpleWebTests extends Driver {
    protected SimpleWebTests() {
        super();
    }

    @Test(description = "Open website", groups = "web")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        //1 check URL
        assertEquals(driver().getCurrentUrl(), SUT + "/");
        //2 check page title
        assertEquals(driver().getTitle(), "Internet Assigned Numbers Authority");
        System.out.println("Site opening done");
    }
}
