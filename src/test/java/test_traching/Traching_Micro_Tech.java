package test_traching;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Traching_Micro_Tech {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		// playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();
		LaunchOptions launchOptions;
		launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath));

		Browser browser;
		browser = playwright.chromium().launch(launchOptions);
		
		//Browser browser;
		//browser = playwright.chromium()
				//.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));

		//Add Screen Tracing  Code
		BrowserContext context = browser.newContext();
		context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
		////////////////////////////////
		Page page;
		page = context.newPage();
		// page.navigate("https://github.com/mahfoozt");
		page.navigate("https://it.microtechlimited.com");
		//Get page title
		System.out.println(page.title());
		//click Login In
		Thread.sleep(2000);
		page.click("text=LOG IN");
		//Click on User Id 
		Thread.sleep(2000);
		page.locator("//input[@name='mailuid']").fill("testpilot@gmail.com");
		Thread.sleep(1000);
		page.locator("//input[@name='pwd']").fill("1234");
		Thread.sleep(1000);
		page.click("//input[@name='login-submit']");
		Thread.sleep(1000);
		System.out.println(page.title());
		Thread.sleep(1000);
		page.goBack();
		
		// Stop tracing and export it into a zip archive.
		context.tracing().stop(
				new Tracing.StopOptions().setPath(
						Paths.get("C:\\Java\\webpage\\Trace_Viewers\\trace.zip")));
		//////////////////////////
		// Close all option
		
		// page.close();
		//context.close();
		// browser.close();
		// playwright.close();
	}

}
