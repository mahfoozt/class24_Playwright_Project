package test_assertion;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Class4Asser_Wiki {

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
	    Thread.sleep(2000);
	    page.locator("input[name=\"search\"]").press("Enter");
	    
	    System.out.println(page.title());
	    assertThat(page.locator("//span[text()='Playwright']")).hasText("Playwright");
//	    String landingSms= page.textContent("//span[text()='Playwright']");
//	    if(landingSms.contains("Playwright")) {
//	    	System.out.println("Test is pass");
//	    }else {
//	    	System.out.println("Test is fail");
//	    }
	    //Verify the Early 
	    Thread.sleep(2000);
	    page.locator("//div[text()='Early playwrights']").click();
	    Thread.sleep(2000);
	    assertThat(page.locator("//span[text()='Early playwrights']")).hasText("Early playwrights");
	    
//	    String landingSms1= page.textContent("//span[text()='Early playwrights']");
//	    if(landingSms1.contains("Early playwrights")) {
//	    	System.out.println("Test1 is pass");
//	    }else {
//	    	System.out.println("Test1 is fail");
//	    }
	    
	    //assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());		
		// Absolute xPath = /html/body/div[2]/form/input[1]
		// relative xPath = //input[name="mailuid"]
		
		page.close();
		browser.close();
		playwright.close();
		
	}

}
