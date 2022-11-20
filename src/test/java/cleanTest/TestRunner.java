package cleanTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import singletonSession.Session;
import utils.GetProperties;


/*@Cucumber
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"src/test/java/cleanTest/todoIstCucumber"},
        plugin = {"json:test/report/cucumber_report.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
//        tags = {"@backend"}
)*/
@IncludeEngines("cucumber")
@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@math")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "cleanTest")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "json:test/report/cucumber_report.json")
public class TestRunner {

    @AfterAll
    public static void after_all() {
        try {

            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @After
    public void cleanup(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Session.getInstance().closeBrowser();
    }
}
