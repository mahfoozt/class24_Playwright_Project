package test_table;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Class5_Craigslist {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));
		Page page;
		page = browser.newPage();
		
		page.navigate("https://www.craigslist.org");
		System.out.println( page.title() );
		Thread.sleep(2000);	
		//click community
		page.locator("//*[@id='ccc']/h3/a/span").click();
		Thread.sleep(2000);
		page.locator("//a[text()='pets']").click();
		Thread.sleep(1000);
		page.locator("//span[text()='puppies']").click();
		

//		page.close();
//		browser.close();
//		playwright.close();
	
		
		
		
		
//		page.locator("//input[@id='query']").click();
//		Thread.sleep(2000);
//		page.locator("//input[@id='query']").fill("camera");
//		Thread.sleep(2000);
//		page.locator("//input[@id='query']").press("Enter");
//		
//		
//		
//		// Text input--------------------------------------------------------------
//		page.getByRole(AriaRole.TEXTBOX).fill("Peter");
//
//		// Date input
//		page.getByLabel("Birth date").fill("2020-02-02");
//
//		// Time input
//		page.getByLabel("Appointment time").fill("13-15");
//
//		// Local date time input
//		page.getByLabel("Local time").fill("2020-03-02T05:15");
//		
//		// Hit Enter
//		page.getByText("Submit").press("Enter");
//
//		// Dispatch Control+Right
//		page.getByRole(AriaRole.TEXTBOX).press("Control+ArrowRight");
//
//		// Press $ sign on keyboard
//		page.getByRole(AriaRole.TEXTBOX).press("$");

	}

}
