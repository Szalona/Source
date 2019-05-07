package step;

import cucumber.api.java.Before;
import setup.Base;
import setup.Browser;


public class HookStep extends Base {
    @Before
    public void beforeScenario() {
        setBrowserOpenURL(Browser.CHROME, PLATFORM_URL);
    }

//    @After
//    public void afterScenario() {
//        closeBrowser(chrome);
//    }
}
