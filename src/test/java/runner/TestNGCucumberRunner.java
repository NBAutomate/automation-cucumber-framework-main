package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "src/test/resources/features/RoomBooking.feature",
	    glue = {"stepdefinitions", "hooks"},
	    tags = "@booking",
	    plugin = {"pretty", "html:target/cucumber-reports"},
	    monochrome = true
	)


		public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
		}
