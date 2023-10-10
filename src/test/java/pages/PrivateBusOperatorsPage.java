package pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivateBusOperatorsPage

{

	@FindBy(xpath = "//span[text()='Travels Directory']")
	WebElement validate_Tpage;

	@FindBy(xpath = "//a[text()='I']")
	WebElement link_I;

	@FindBy(xpath = "//a[text()='R']")
	WebElement link_R;

	@FindBy(xpath = "//a[text()='A']")
	WebElement link_A;
	@FindBy(xpath = "//div[@class='D113_pagination']//a[text()='3']")
	WebElement srollpagination;
	@FindBy(xpath = "//div[@class='D113_pagination']//a[text()='3']")
	WebElement link_pagination3;
	@FindBy(xpath = "//ul[@class='D113_ul']//li")
	List<WebElement> list_data;

	WebDriver driver;

	public PrivateBusOperatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validate_OperatorDirectorypage() {
		validate_Tpage.isDisplayed();
	}

	public void clickOperatorDirectory() throws InterruptedException {
		link_I.click();
		Thread.sleep(1000);
		link_R.click();
		Thread.sleep(1000);
		link_A.click();
	}

	public void scrollTopagination() throws InterruptedException {

		JavascriptExecutor jvs = (JavascriptExecutor) driver;
		jvs.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(1000);

	}

	public void clickOnPaginationPage()

	{
		link_pagination3.click();
	}

	public void printOperatorsInfile()

	{
		/// Create file and writing data to this file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt")))

		{

			for (WebElement web : list_data)

			{
				String text = web.getText();
				System.out.println(text);

				writer.write(text);
				writer.newLine();
			}
			System.out.println("Text data written to output.txt");
		}

		catch (IOException e)

		{
			e.printStackTrace();
		}

	}

}
