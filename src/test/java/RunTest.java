import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/feature/AddMovie/AddMovie.feature",
                 glue = "Steps",
                 plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class RunTest extends AbstractTestNGCucumberTests {

}
