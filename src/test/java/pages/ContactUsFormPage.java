package pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class ContactUsFormPage extends BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(className = "alert-danger")
    WebElement redAlertBox;

    @FindBy(className = "alert-success")
    WebElement greenAlertBox;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "id_contact")
    WebElement subjectSelect;

    @FindBy(id = "id_order")
    WebElement orderReferenceInput;

    @FindBy(id = "message")
    WebElement messageTextArea;


    public void clickSendButton() {
        sendButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(redAlertBox);

    }

    public boolean isGreenAlertBoxDisplayed() {
        return isAlertBoxDisplayed(greenAlertBox);
    }

    private boolean isAlertBoxDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));

        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;

    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void sendContactUsForm(Message message) {
        enterEmail(message.getEmail());
        Select select = new Select(subjectSelect);
        select.selectByVisibleText(message.getSubject().getValue());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageTextArea.sendKeys(message.getMessage());
        clickSendButton();
    }
}

