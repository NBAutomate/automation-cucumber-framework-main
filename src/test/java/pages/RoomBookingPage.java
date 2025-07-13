package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class RoomBookingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Hotel Information Section
    @FindBy(xpath = "//section[@class='hero py-5']")
    private WebElement hotelLogo;

    @FindBy(xpath = "//span[normalize-space()='Shady Meadows B&B']")
    private WebElement hotelName;

    @FindBy(xpath = "//p[@class='lead mb-4']")
    private WebElement hotelDescription;

    @FindBy(xpath = "//i[@class='bi bi-telephone me-2']")
    private WebElement hotelContact;

    @FindBy(xpath = "//div[@class='pigeon-click-block']")
    private WebElement hotelMap;

    @FindBy(xpath="//a[normalize-space()='Book Now']")
    private WebElement bookNow;

    @FindBy(xpath="//button[normalize-space()='Check Availability']")
    private WebElement searchButton;


    @FindBy(xpath = "//a[@class='nav-link'][normalize-space()='Rooms']")
    private WebElement roomsLink;

    //@FindBy(css = ".room")
    @FindBy(css = "section[id='rooms'] div[class='row g-4']")
    private List<WebElement> roomsList;

    //@FindBy(css = ".room-price")
    @FindBy(css = ".room-price")
    private List<WebElement> roomPrices;

    //@FindBy(xpath = "(//a[@class='btn btn-primary'][normalize-space()='Book now'])")
    @FindBy(linkText = "Book now")
    private List<WebElement> bookButtons;

    // Booking Form Elements
    @FindBy(xpath = "//div[@class='card-body']//form")
    private WebElement bookingForm;

    @FindBy(xpath = "//input[@placeholder='Firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//label[@for='checkin']//parent::div//child::input[@value]")
    private WebElement checkinField;

    @FindBy(xpath = "//label[@for='checkout']//parent::div//child::input[@value]")
    private WebElement checkoutField;

    @FindBy(xpath = "//button[normalize-space()='Reserve Now']")
    private WebElement ReserveNowButton;

    // Booking Confirmation and Error Messages
    @FindBy(xpath = "//h2[normalize-space()='Booking Confirmed']")
    private WebElement bookingConfirmation;

    @FindBy(xpath = "//p[contains(text(),'Your booking has been confirmed for the following ')]")
    private WebElement bookingConfirmationMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement validationError;

    @FindBy(xpath = "//div[@class='booking-summary']")
    private WebElement bookingSummary;

    // Room Information
    @FindBy(xpath = "//div[@class='room-info']")
    private WebElement roomInfo;

    @FindBy(xpath = "//div[@class='room-price']")
    private WebElement roomPrice;

    @FindBy(xpath = "//div[@class='room-amenities']")
    private WebElement roomAmenities;

    // Page Elements for Validation
    @FindBy(xpath = "//div[@class='row hotel-room-info']")
    private WebElement hotelRoomSection;

    @FindBy(xpath = "//div[@class='col-sm-4']")
    private WebElement hotelInfoSection;

    @FindBy(xpath = "//div[@class='col-sm-8']")
    private WebElement bookingSection;

    public RoomBookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Hotel Information Methods
    public boolean isHotelLogoDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(hotelLogo)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHotelNameDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(hotelName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getHotelName() {
        return wait.until(ExpectedConditions.visibilityOf(hotelName)).getText();
    }

    public boolean isHotelDescriptionDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(hotelDescription)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHotelContactDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(hotelContact)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Booking Form Methods
    public boolean isBookingFormDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(bookingForm)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFirstNameFieldPresent() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Firstname']"))) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLastNameFieldPresent() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Lastname']"))) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailFieldPresent() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Lastname']"))) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPhoneFieldPresent() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Phone']"))) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCheckinFieldPresent() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='checkin']//parent::div//child::input[@value]"))) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCheckoutFieldPresent() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='checkout']//parent::div//child::input[@value]"))) != null;
        } catch (Exception e) {
            return false;
        }
    }

    // Form Field Interaction Methods
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneField)).clear();
        phoneField.sendKeys(phone);
    }

    public void clickBookNowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(bookNow));
        bookNow.click();
    }



//    public void enterCheckinDate(String checkinDate) {
//        wait.until(ExpectedConditions.elementToBeClickable(checkinField)).clear();
//        checkinField.sendKeys(checkinDate);
//    }

    public void enterCheckinDate(String checkinDate) {
        wait.until(ExpectedConditions.elementToBeClickable(checkinField));

        // Select all text and delete it
        checkinField.sendKeys(Keys.CONTROL + "a");
        checkinField.sendKeys(Keys.DELETE);

        // Now enter the new date
        checkinField.sendKeys(checkinDate);
    }

    public void enterCheckoutDate(String checkoutDate) {

        wait.until(ExpectedConditions.elementToBeClickable(checkoutField));

        // Select all text and delete it
        checkoutField.sendKeys(Keys.CONTROL + "a");
        checkoutField.sendKeys(Keys.DELETE);

        // Now enter the new date
        checkoutField.sendKeys(checkoutDate);

//        // Remove readonly and clear value with JS
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].removeAttribute('readonly'); arguments[0].value = '';", checkoutField);
//
//        // Send new value
//        checkoutField.sendKeys(checkoutDate);

    }

    public void clickCheckAvailabilityButton() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", searchButton);
//        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//        searchButton.click();

        safeClick(searchButton);
    }
    public void RoomLink() {
        wait.until(ExpectedConditions.elementToBeClickable(roomsLink));
        roomsLink.click();
    }

    public boolean areRoomsDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".room")));
            return roomsList.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areRoomPricesDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".room-price")));
            return roomPrices.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

//    public void selectFirstRoom() {
//        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Book now'])[1]"))); //By.cssSelector(".btn-book")
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//section[@id='rooms'])")));
//
//        if (bookButtons.size() > 0) {
//            bookButtons.get(0).click();
//        }
//    }

    public void selectFirstRoom() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='rooms']")));

        if (!bookButtons.isEmpty()) {
            safeClick(bookButtons.get(0));
        } else {
            throw new NoSuchElementException("No 'Book now' buttons found!");
        }
    }



    public void clickReserveNowButton() {
        safeClick(ReserveNowButton);
    }

    // Booking Form Filling Method
    public void fillBookingForm(String firstName, String lastName, String email, String phone) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPhone(phone);
    }

    // Validation and Result Methods


    public boolean isBookingConfirmationDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(bookingConfirmation)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isBookingConfirmationmessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(bookingConfirmationMessage)).isDisplayed();
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

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isValidationErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(validationError)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getValidationError() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(validationError)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    // Field Validation Methods
    public boolean isFieldEmpty(String fieldName) {
        try {
            WebElement field = getFieldByName(fieldName);
            return field.getAttribute("value").isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFieldRequired(String fieldName) {
        try {
            WebElement field = getFieldByName(fieldName);
            return field.getAttribute("required") != null;
        } catch (Exception e) {
            return false;
        }
    }

    private WebElement getFieldByName(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "firstname":
                return firstNameField;
            case "lastname":
                return lastNameField;
            case "email":
                return emailField;
            case "phone":
                return phoneField;
            case "checkin":
                return checkinField;
            case "checkout":
                return checkoutField;
            default:
                throw new IllegalArgumentException("Unknown field name: " + fieldName);
        }
    }

    // Field Type Validation Methods
    public boolean isFieldAcceptingTextInput(String fieldName) {
        try {
            WebElement field = getFieldByName(fieldName);
            String fieldType = field.getAttribute("type");
            return fieldType.equals("text") || fieldType.equals("email") || fieldType.equals("tel");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFieldDatePicker(String fieldName) {
        try {
            WebElement field = getFieldByName(fieldName);
            String fieldType = field.getAttribute("type");
            return fieldType.equals("date");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasEmailValidation() {
        try {
            String fieldType = emailField.getAttribute("type");
            return fieldType.equals("email");
        } catch (Exception e) {
            return false;
        }
    }

    // Performance and Accessibility Methods
    public boolean isPageLoadedWithin(int seconds) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='container-fluid']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areAllImagesLoaded() {
        try {
            List<WebElement> images = driver.findElements(By.tagName("img"));
            for (WebElement img : images) {
                Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0", img);
                if (!imageLoaded) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasProperLabels() {
        try {
            List<WebElement> inputs = driver.findElements(By.tagName("input"));
            for (WebElement input : inputs) {
                String id = input.getAttribute("id");
                if (id != null && !id.isEmpty()) {
                    List<WebElement> labels = driver.findElements(By.xpath("//label[@for='" + id + "']"));
                    if (labels.isEmpty()) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasProperHeadingStructure() {
        try {
            List<WebElement> headings = driver.findElements(By.xpath("//h1 | //h2 | //h3 | //h4 | //h5 | //h6"));
            return !headings.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // Responsive Design Methods
    public boolean isResponsiveLayout() {
        try {
            // Check for responsive classes or viewport meta tag
            List<WebElement> responsiveElements = driver.findElements(By.xpath("//*[contains(@class, 'col-') or contains(@class, 'responsive')]"));
            return !responsiveElements.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // Utility Methods
    public void waitForPageToLoad() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='container-fluid']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Book Now']")));
    }

    public void scrollToBookingForm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookingForm);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void priceSummaryDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()='Price Summary']")));
    }
}