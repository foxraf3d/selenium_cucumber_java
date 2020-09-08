package TestRunner;

import Utilities.TestUtilities;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static Utilities.BrowserDefinition.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features=".//Features/Dasa.feature",
        glue = "StepDefinitions",
        monochrome = true,
        plugin = {"pretty", "html:test-output.html"}
)
public class TestRun{

    @AfterClass
    public static void killChromeBrowser(){
        TestUtilities utils = new TestUtilities();
        utils.killBrowser(CHROME);
        utils.killBrowser(FIREFOX);
    }

}
