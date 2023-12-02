package test_screenshot;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Class4Screenshot_Wiki {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		//playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType
				.LaunchOptions()
				.setHeadless(false)
				.setExecutablePath(Paths.get(chromePath)));
		Page page;
		page = browser.newPage();
		
		page.navigate("https://www.wikipedia.org/");
		Thread.sleep(2000);
	    page.locator("input[name=\"search\"]").click();
	    Thread.sleep(2000);
	    page.locator("input[name=\"search\"]").fill("playwright");
	  //screen shot
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/Wiki_Page.png")));
		Thread.sleep(1000);
	   
	    page.locator("input[name=\"search\"]").press("Enter");
	    //Verify 
	    System.out.println(page.title());
	    String landingSms= page.textContent("//span[text()='Playwright']");
	    if(landingSms.contains("Playwright")) {
	    	System.out.println("Test is pass");
	    }else {
	    	System.out.println("Test is fail");
	    }
	    Thread.sleep(2000);
	    page.locator("//div[text()='Early playwrights']").click();    
	    String landingSms1= page.textContent("//span[text()='Early playwrights']");
	    if(landingSms1.contains("Early playwrights")) {
	    	System.out.println("Test1 is pass");
	    }else {
	    	System.out.println("Test1 is fail");
	    }
	    
	    //assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());		
		// Absolute xPath = /html/body/div[2]/form/input[1]
		// relative xPath = //input[name="mailuid"]
		
		page.close();
		browser.close();
		playwright.close();
		
	}

}
