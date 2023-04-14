package cleanTest;


import io.cucumber.java.*;
import io.cucumber.junit.platform.engine.Constants;
import org.json.JSONObject;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import singletonSession.Session;
import utils.GetProperties;
import java.io.FileWriter;
import java.io.IOException;

import static utils.JsonCreator.createJsonFilewithBrowserAndOs;


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
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "json:reports/cucumber_report.json")
public class TestRunner {
    static String browserName;
    static String browserVersion;
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

        // Obtener las capacidades del navegador
        Capabilities capabilities = ((RemoteWebDriver) Session.getInstance().getBrowser()).getCapabilities();

        // Obtener el nombre del navegador y su versión
        browserName = capabilities.getBrowserName();
        browserVersion = capabilities.getBrowserVersion();
        //Crea archivo json con info de browser y os
        createJsonFilewithBrowserAndOs(browserName,browserVersion);

        Session.getInstance().closeBrowser();
    }
}
