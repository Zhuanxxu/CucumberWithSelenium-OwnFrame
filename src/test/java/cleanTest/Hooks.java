package cleanTest;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import singletonSession.Session;
import utils.GetProperties;

public class Hooks {
   /* @Before
    public void setUp(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @After
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }*/
}
