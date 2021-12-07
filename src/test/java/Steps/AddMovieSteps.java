package Steps;

import Pages.MoviePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class AddMovieSteps {

    protected WebDriver webDriver = null;
    private MoviePage moviePage = null;
    private final SoftAssert softAssert = new SoftAssert();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Given("user is on landpage")
    public void userEnterMoviePage() {
        moviePage = new MoviePage(webDriver);
        moviePage.setMoviePage();
    }

    @When("add a movie")
    public void userAddMovie() {
        moviePage.inputScriptOfMovie();
        moviePage.uploadImage();
    }


    @Then("movie is add to gallery")
    public void movieWasAdded() {

    }

    @When("user modified a movie")
    public void modifyMovie(){
        moviePage.editMovie();
    }

    @When("User delete an item")
    public void deleteAnItem(){
        moviePage.deleteMovie();
    }

    @Then("check maximum long and text exist")
    public void checkLong(){
        softAssert.assertTrue(moviePage.isCreatedItemAllowed(),"the long requirement is wrong");
        softAssert.assertTrue(moviePage.isParagraphContainsText(),"the text does not contain the appropriate paragraph");
    }

}
