package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BasePage extends Wait {

    private final WebDriver driver;
    private final Properties properties;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ProjectPath/properties.properties");
            properties.load(fileInputStream);
        } catch (IOException loadError) {
            loadError.printStackTrace();
        }
    }

    WebElement getElement(By locator) {
        waitUntilElementIsVisible(locator, driver);
        return driver.findElement(locator);
    }

    void clickElement(By locator) {
        waitUntilElementToBeClicked(locator, driver);
        driver.findElement(locator).click();
    }

    void writeText(By locator, String words) {
        waitUntilElementToBeClicked(locator, driver);
        driver.findElement(locator).sendKeys(words);
    }

    public String getProperty(String pathProperty) {
        return properties.getProperty(pathProperty);
    }

    public void uploadFile(String pathImage, By locator) {
        driver.findElement(locator).sendKeys(pathImage);
    }

    public void setPage(String page){
        driver.get(page);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void selectAll(By locator){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void clearField(By locator){
        getElement(locator).clear();
    }

    public boolean isElementEnabled(By locator){
        return driver.findElement(locator).isEnabled();
    }

    public List<WebElement> getListOfElements(By locator){
        return driver.findElements(locator);
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }
}
