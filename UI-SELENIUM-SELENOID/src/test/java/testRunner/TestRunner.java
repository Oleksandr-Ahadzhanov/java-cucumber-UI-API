package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//oah//IdeaProjects//java-cucumber-UI-API//UI-SELENIUM-SELENOID//features",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }
)

public class TestRunner {
}
