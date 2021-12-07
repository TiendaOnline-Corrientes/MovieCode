package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MoviePage extends BasePage {

    //variables
    private final By
            scriptTextBox = By.cssSelector(".form-control[placeholder='Maximum allowed length: 300 characters']"),
            uploadImageButton = By.id("inputImage"),
            createItemButton = By.xpath("//button[text()='Create Item']"),
            editItemButton = By.xpath("(//*[text()='Edit']) [1]"), fieldToModifyLocator = By.xpath("//textarea"),
            updateItemButton = By.xpath("//*[text()='Update Item']"),
            deleteItemButton = By.xpath("(//*[text()='Delete'])[2]"),
            deleteButtonDisclaimer = By.xpath("//*[text()='Yes, delete it!']"),
            moviesParagraph = By.xpath("//p");

    private final String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";
    private final StringBuilder newText = new StringBuilder();

    //constructor
    public MoviePage(WebDriver webDriver) {
        super(webDriver);
    }

    //methods

    public void setMoviePage() {
        setPage(getProperty("mainPage"));
    }

    public void inputScriptOfMovie() {
        writeText(scriptTextBox, Text.SCRIPT_TEXT.getText());
    }

    public void uploadImage() {
        uploadFile(getProperty("LocationImage"), uploadImageButton);
        clickElement(createItemButton);
    }

    private String writeRandomText(int characters) {
        for (int comparator = 0; comparator < characters; comparator++) {
            int index = (int) (alphaNumericString.length() * Math.random());
            newText.append(alphaNumericString.charAt(index));
        }
        return newText.toString();
    }

    public void editMovie() {
        clickElement(editItemButton);
        clearField(fieldToModifyLocator);
        writeText(fieldToModifyLocator, writeRandomText(300));
        clickElement(updateItemButton);
    }

    public void deleteMovie() {
        clickElement(deleteItemButton);
        clickElement(deleteButtonDisclaimer);
    }

    public boolean isCreatedItemAllowed() {
        writeText(scriptTextBox, writeRandomText(301));
        return isElementEnabled(createItemButton);
    }

    public boolean isParagraphContainsText() {
        getListOfElements(moviesParagraph).forEach(movie -> System.out.println(getTextFromElement(movie)));
        return getListOfElements(moviesParagraph).stream().anyMatch(moviesParagraph -> getTextFromElement(moviesParagraph).equals(Text.TEXT_TO_VALIDATE.getText()));
    }

}