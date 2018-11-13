package mobile.hw3.setup;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static mobile.hw3.enums.PropertyTypes.*;

@Test(groups = {"native", "web"})
public class Hooks extends Driver {

    protected Hooks() {
        super();
    }

    @BeforeGroups(groups = "native")
    public void setUpNative() throws Exception {
        initProperties(NATIVE_FARM);
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @BeforeGroups(groups = "web")
    public void setUpWeb() throws Exception {
        initProperties(WEB_FARM);
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @AfterGroups(groups = {"native", "web"})
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }

}
