package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "(//a[text()='View All'])[2]")
	WebElement ScrollviewPage;

	@FindBy(xpath = "(//a[text()='View All'])[2]")
	WebElement link_viewall;
	@FindBy(xpath = "//h1[text()='India’s No. 1 Bus Ticket Booking Site']")
	WebElement txt_validatehomepage;

	WebDriver driver;

	public HomePage(WebDriver driver)

	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	/// Varify is it home page
	public void homepageValidate() {
		try {
			txt_validatehomepage.isDisplayed();
			System.out.println("home page validated sucessfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/// Sroll the page till "Bus Operators"
	public void srollToview() throws Exception {

		JavascriptExecutor jvs = (JavascriptExecutor) driver;
		jvs.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);

	}
	/// Click on "View All Link"

	public void clickViewAllForBusOperators() throws InterruptedException {

		link_viewall.click();
		Thread.sleep(3000);
	}

}
