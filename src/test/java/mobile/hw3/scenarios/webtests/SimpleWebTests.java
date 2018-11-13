package mobile.hw3.scenarios.webtests;

import mobile.hw3.setup.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static mobile.hw3.enums.Websites.IANA;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class SimpleWebTests extends Driver {
    protected SimpleWebTests() {
        super();
    }

    private final String url = "https://%s/";

    @Test(description = "Open website", groups = "web")
    public void webTest() throws Exception {
        driver().get(String.format(url, IANA.sut));
        driverWait().until(ExpectedConditions.urlToBe(String.format(url, IANA.sut)));
        //1 check URL
        assertEquals(driver().getCurrentUrl(), String.format(url, IANA.sut));
        //2 check page title
        assertEquals(driver().getTitle(), IANA.title);
        System.out.println("Site opening done");
    }
}
