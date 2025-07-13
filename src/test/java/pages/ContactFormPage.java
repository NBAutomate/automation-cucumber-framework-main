package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.List;

public class ContactFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Contact Form Elements
    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "subject")
    private WebElement subjectField;

    @FindBy(id = "description")
    private WebElement messageField;

    @FindBy(id = "submitContact")
    private WebElement submitButton;

    // Success and Error Messages
    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;

    @FindBy(css = ".has-error")
    private List<WebElement> fieldErrors;

    @FindBy(css = "#name + .text-danger")
    private WebElement nameError;

    @FindBy(css = "#email + .text-danger")
    private WebElement emailError;

    @FindBy(css = "#phone + .text-danger")
    private WebElement phoneError;

    @FindBy(css = "#subject + .text-danger")
    private WebElement subjectError;

    @FindBy(css = "#description + .text-danger")
    private WebElement messageError;

    // Contact Section Navigation
    @FindBy(css = "a[href='#contact']")
    private WebElement contactLink;

    @FindBy(id = "contact")
    private WebElement contactSection;

    // Constructor
    public ContactFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Navigation Methods
    public void navigateToContactForm() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink));
        contactLink.click();
        wait.until(ExpectedConditions.visibilityOf(contactSection));
    }

    public void scrollToContactForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", contactSection);
    }

    // Form Input Methods
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void enterSubject(String subject) {
        wait.until(ExpectedConditions.visibilityOf(subjectField));
        subjectField.clear();
        subjectField.sendKeys(subject);
    }

    public void enterMessage(String message) {
        wait.until(ExpectedConditions.visibilityOf(messageField));
        messageField.clear();
        messageField.sendKeys(message);
    }

    // Form Submission Methods
    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public long getFormSubmissionTime() {
        long startTime = System.currentTimeMillis();
        submitForm();
        waitForSuccessMessage();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    // Form Validation Methods
    public boolean isFieldAcceptingTextInput(String fieldName) {
        WebElement field = getFieldByName(fieldName);
        if (field != null) {
            String beforeValue = field.getAttribute("value");
            field.sendKeys("test");
            String afterValue = field.getAttribute("value");
            return !beforeValue.equals(afterValue);
        }
        return false;
    }

    public boolean isFieldAcceptingNumericInput(String fieldName) {
        WebElement field = getFieldByName(fieldName);
        if (field != null) {
            String beforeValue = field.getAttribute("value");
            field.clear();
            field.sendKeys("1234567890");
            String afterValue = field.getAttribute("value");
            return afterValue.equals("1234567890");
        }
        return false;
    }

    public boolean isFieldRejectingNonNumericInput(String fieldName) {
        WebElement field = getFieldByName(fieldName);
        if (field != null) {
            field.clear();
            field.sendKeys("abcd1234");
            String value = field.getAttribute("value");
            // Check if non-numeric characters are filtered out
            return !value.contains("abcd");
        }
        return false;
    }

    // Message and Error Validation Methods
    public boolean isSuccessMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areValidationErrorsDisplayed() {
        return fieldErrors.size() > 0;
    }

    public boolean isEmailValidationErrorDisplayed() {
        try {
            return emailError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPhoneValidationErrorDisplayed() {
        try {
            return phoneError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getSuccessMessageText() {
        if (isSuccessMessageDisplayed()) {
            return successMessage.getText();
        }
        return "";
    }

    public String getErrorMessageText() {
        if (isErrorMessageDisplayed()) {
            return errorMessage.getText();
        }
        return "";
    }

    // Form State Methods
    public boolean isFormCleared() {
        return nameField.getAttribute("value").isEmpty() &&
                emailField.getAttribute("value").isEmpty() &&
                phoneField.getAttribute("value").isEmpty() &&
                subjectField.getAttribute("value").isEmpty() &&
                messageField.getAttribute("value").isEmpty();
    }

    public void clearForm() {
        nameField.clear();
        emailField.clear();
        phoneField.clear();
        subjectField.clear();
        messageField.clear();
    }





    // Wait Methods
    public void waitForSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    public void waitForErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
    }

    // Utility Methods
    private WebElement getFieldByName(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "name":
                return nameField;
            case "email":
                return emailField;
            case "phone":
                return phoneField;
            case "subject":
                return subjectField;
            case "message":
            case "description":
                return messageField;
            default:
                return null;
        }
    }

    // Fill Form Methods
    public void fillContactForm(String name, String email, String phone, String subject, String message) {
        enterName(name);
        enterEmail(email);
        enterPhone(phone);
        enterSubject(subject);
        enterMessage(message);
    }

    public void fillContactFormWithEmptyData() {
        clearForm();
    }

    // Form Field Getters for Validation
    public String getNameValue() {
        return nameField.getAttribute("value");
    }

    public String getEmailValue() {
        return emailField.getAttribute("value");
    }

    public String getPhoneValue() {
        return phoneField.getAttribute("value");
    }

    public String getSubjectValue() {
        return subjectField.getAttribute("value");
    }

    public String getMessageValue() {
        return messageField.getAttribute("value");
    }
}