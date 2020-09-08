package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features=".//Features/Dasa.feature",
        glue = "StepDefinitions",
        monochrome = true,
        plugin = {"pretty", "html:test-output.html"}
)
public class TestRun{}
