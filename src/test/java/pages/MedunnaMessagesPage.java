package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaMessagesPage {

    public MedunnaMessagesPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[.='Create a new Message']")
    public WebElement createANewMessageLink;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(id = "c-message-email")
    public WebElement email;

    @FindBy(id = "c-message-subject")
    public WebElement subject;

    @FindBy(id = "c-message-message")
    public WebElement message;

    @FindBy(id = "save-entity")
    public WebElement saveSubmitButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;

}
