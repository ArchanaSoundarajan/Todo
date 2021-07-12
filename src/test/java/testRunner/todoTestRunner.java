package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/todolist.feature",
        glue = "stepDefinitions",
        monochrome =true,
        plugin ={"pretty","junit:target/JUnitReports/report.xml," +
                "json:target/JSONReports/report.json", "html:target/HtmReports"}
)


class TestRunner {

}