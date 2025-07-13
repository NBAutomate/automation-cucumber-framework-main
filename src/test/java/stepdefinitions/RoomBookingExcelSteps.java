//package stepdefinitions;
//
//import base.BaseTest;
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//import pages.RoomBookingPage; //changed
//import utils.ExcelUtil;
//import utils.StepLogger;
//
//import java.util.List;
//import java.util.Map;
//
//public class FinalHotelBookingExcelSteps extends BaseTest {
//
//    private RoomBookingPage hotelBookingPage;   //changed
//    private int successfulBookings = 0;
//    private int failedBookings = 0;
//
//    @When("user creates bookings from Excel file {string} sheet {string}")
//    public void user_creates_bookings_from_excel_file_sheet(String fileName, String sheetName) {
//        String step = "When user creates bookings from Excel file " + fileName + " sheet " + sheetName;
//        try {
//            hotelBookingPage = new RoomBookingPage(driver); //changed
//            String filePath = System.getProperty("user.dir") + "/testdata/" + fileName;
//
//            List<Map<String, String>> bookingData = ExcelUtil.getBookingDataFromExcel(filePath, sheetName);
//
//            successfulBookings = 0;
//            failedBookings = 0;
//
//            for (Map<String, String> booking : bookingData) {
//                try {
//                    hotelBookingPage.fillBookingForm(
//                            booking.get("firstname"),
//                            booking.get("lastname"),
//                            booking.get("email"),
//                            booking.get("phone"),
//                            booking.get("checkin"),
//                            booking.get("checkout")
//                    );
//
//                    hotelBookingPage.clickBookButton();
//                    Thread.sleep(2000); // Wait for response
//
//                    if (hotelBookingPage.isBookingConfirmationDisplayed()) {
//                        successfulBookings++;
//                    } else {
//                        failedBookings++;
//                    }
//
//                    // Reset form for next booking
//                    driver.navigate().refresh();
//                    Thread.sleep(2000);
//
//                } catch (Exception e) {
//                    failedBookings++;
//                    System.out.println("Booking failed for: " + booking.get("firstname") + " " + booking.get("lastname"));
//                }
//            }
//
//            StepLogger.logPass(step + " - Processed " + bookingData.size() + " bookings");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//
//    @When("user attempts bookings from Excel file {string} sheet {string}")
//    public void user_attempts_bookings_from_excel_file_sheet(String fileName, String sheetName) {
//        String step = "When user attempts bookings from Excel file " + fileName + " sheet " + sheetName;
//        try {
//            hotelBookingPage = new FianlHotelBookingPage(driver); //changed
//            String filePath = System.getProperty("user.dir") + "/testdata/" + fileName;
//
//            List<Map<String, String>> bookingData = ExcelUtil.getBookingDataFromExcel(filePath, sheetName);
//
//            successfulBookings = 0;
//            failedBookings = 0;
//
//            for (Map<String, String> booking : bookingData) {
//                try {
//                    hotelBookingPage.fillBookingForm(
//                            booking.get("firstname"),
//                            booking.get("lastname"),
//                            booking.get("email"),
//                            booking.get("phone"),
//                            booking.get("checkin"),
//                            booking.get("checkout")
//                    );
//
//                    hotelBookingPage.clickBookButton();
//                    Thread.sleep(2000); // Wait for response
//
//                    if (hotelBookingPage.isBookingConfirmationDisplayed()) {
//                        successfulBookings++;
//                    } else {
//                        failedBookings++;
//                    }
//
//                    // Reset form for next booking
//                    driver.navigate().refresh();
//                    Thread.sleep(2000);
//
//                } catch (Exception e) {
//                    failedBookings++;
//                    System.out.println("Booking attempt failed for: " + booking.get("firstname") + " " + booking.get("lastname"));
//                }
//            }
//
//            StepLogger.logPass(step + " - Attempted " + bookingData.size() + " bookings");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//
//    @Then("all bookings should be created successfully")
//    public void all_bookings_should_be_created_successfully() {
//        String step = "Then all bookings should be created successfully";
//        try {
//            Assert.assertTrue(successfulBookings > 0, "No bookings were created successfully");
//            Assert.assertEquals(failedBookings, 0, "Some bookings failed: " + failedBookings + " out of " + (successfulBookings + failedBookings));
//            StepLogger.logPass(step + " - " + successfulBookings + " bookings created successfully");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//
//    @Then("booking confirmations should be displayed")
//    public void booking_confirmations_should_be_displayed() {
//        String step = "Then booking confirmations should be displayed";
//        try {
//            Assert.assertTrue(successfulBookings > 0, "No booking confirmations were displayed");
//            StepLogger.logPass(step + " - " + successfulBookings + " booking confirmations displayed");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//
//    @Then("appropriate error messages should be displayed")
//    public void appropriate_error_messages_should_be_displayed() {
//        String step = "Then appropriate error messages should be displayed";
//        try {
//            Assert.assertTrue(failedBookings > 0, "Expected some bookings to fail but all succeeded");
//            StepLogger.logPass(step + " - " + failedBookings + " bookings failed as expected");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//
//    @Then("bookings should not be created")
//    public void bookings_should_not_be_created() {
//        String step = "Then bookings should not be created";
//        try {
//            Assert.assertTrue(failedBookings > 0, "Expected bookings to fail but they succeeded");
//            StepLogger.logPass(step + " - " + failedBookings + " bookings correctly failed");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//
//    @Then("boundary value bookings should be handled correctly")
//    public void boundary_value_bookings_should_be_handled_correctly() {
//        String step = "Then boundary value bookings should be handled correctly";
//        try {
//            int totalBookings = successfulBookings + failedBookings;
//            Assert.assertTrue(totalBookings > 0, "No boundary value bookings were processed");
//            StepLogger.logPass(step + " - " + totalBookings + " boundary value bookings processed");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//
//    @Then("appropriate responses should be displayed")
//    public void appropriate_responses_should_be_displayed() {
//        String step = "Then appropriate responses should be displayed";
//        try {
//            int totalBookings = successfulBookings + failedBookings;
//            Assert.assertTrue(totalBookings > 0, "No responses were displayed");
//            StepLogger.logPass(step + " - Responses displayed for " + totalBookings + " bookings");
//        } catch (Exception e) {
//            StepLogger.logFail(step, e, driver);
//            throw e;
//        }
//    }
//}