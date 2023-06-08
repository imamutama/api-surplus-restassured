package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/feature"},
        glue = "stepdefs",
        plugin = {"pretty",
                "html:target/cucumber/report.html",
                "json:target/cucumber-reports/CucumberTestReport.json",},
        publish = true
)
public class TestRunner {
}
