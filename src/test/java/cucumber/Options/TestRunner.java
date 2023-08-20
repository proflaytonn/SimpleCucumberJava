package cucumber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
        glue = "StepDefinitions",
        //plugin = "json:target/jsonReports/cucumber-report.json",
        plugin = "html:target/cucumber-reportRefund.html",
        tags = "@Refund"
//        tags = "@RegressionCMSRefund"
//        tags = "@Test"
)
public class TestRunner {
}
