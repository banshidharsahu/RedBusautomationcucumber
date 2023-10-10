package RedBugStepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PrivateBusOperatorsPage;

public class TravelsDirectory_Steps extends BaseClass

{
	WebDriver driver;
	HomePage home;
	PrivateBusOperatorsPage operatorPage;
	BaseClass base;

	@Before()
	public void setupfirst() {
		log = LogManager.getLogger("TravelsDirectory_Steps");
		// System.setProperty("webdriver.chrome.driver",
		// "D:/OBDX _Version/22.1.0.3.0/CucumberjavaSelenium/Driver/chromedriver.exe");
		//
		// ChromeOptions option = new ChromeOptions();
		// option.setBinary("D:/OBDX _Version/22.1.0.3.0/CucumberjavaSelenium/testChromeBrowser/chrome.exe");
		//
		// driver = new ChromeDriver(option);
		// driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		// WebDriverManager.chromedriver().setup();
		//
		// // Create a WebDriver instance for Chrome
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// // Perform your Selenium tests

		log.info("Setup executed......");
	}

	@Given("User navigate to application URL and verify Home page")
	public void user_navigate_to_application_url_and_verify_home_page() throws InterruptedException

	{
		base = new BaseClass();
		String url = base.getUrl();
		driver.get(url);
		log.info("URL opened successfully");
		Thread.sleep(3000);
		home = new HomePage(driver);

		home.homepageValidate();
		log.warn("Home page validated successfully");
	}

	@When("User click on View All for the Private Bus Operators section")
	public void private_bus_operators_section() throws Exception {
		home.srollToview();
		Thread.sleep(1000);
		home.clickViewAllForBusOperators();
		log.warn("user clicked on View All Link");
	}

	@And("Click the operator directories with the alphabet I then R and then back to A")
	public void operator_directories_with_the_alphabet() throws InterruptedException {
		operatorPage = new PrivateBusOperatorsPage(driver);
		operatorPage.clickOperatorDirectory();

	}

	@And("User scroll to the end of the page")
	public void user_scroll_to_the_end_of_the_page() throws InterruptedException {
		operatorPage.scrollTopagination();
	}

	@And("User click on pagination page 3")
	public void user_click_on_pagination_page() {
		operatorPage.clickOnPaginationPage();
	}

	@Then("User print all the operators listed in an output file")
	public void user_print_all_the_operators_listed_in_an_output_file()

	{
		operatorPage.printOperatorsInfile();
	}

	@After()
	public void failledTestscenarioscreenshot(Scenario sc) throws IOException {
		if (sc.isFailed() == true) {
			log.warn("Scenario got failed , taken sceenshot for reference");
			TakesScreenshot take = ((TakesScreenshot) driver);
			File file = take.getScreenshotAs(OutputType.FILE);
			Files.copy(file, new File(
					"D://OBDX _Version//22.1.0.3.0//RedBusPOMcucumber//Screenshot//failledscenario//faiiledscenarioscreenshot.jpg"));
			driver.quit();
		}
	}

}
