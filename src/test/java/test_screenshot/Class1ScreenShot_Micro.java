package test_screenshot;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Class1ScreenShot_Micro {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		// playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));

		Page page;
		page = browser.newPage();
		//Go to MicroTech web page
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
		//screen shot
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/MichroTech_Page.png")));
		Thread.sleep(1000);
		Thread.sleep(1000);
		page.click("//input[@name='login-submit']");
		Thread.sleep(1000);
		//Get page title
		System.out.println(page.title());
		//Verify after employee login page title
		assertThat(page.locator("//h2[text()='Welcome Test ']")).hasText("Welcome Test");
		
		//Verify Salary Status
		assertThat(page.locator("//h2[text()='Salary Status']")).hasText("Salary Status");
		 

		
		Thread.sleep(1000);
		// Web Table Handling
		// Total Row count
		System.out.println("Total Row count "+ page.locator("#divimg > div > table:nth-child(9) > tbody > tr").count());
		
		// First-child column count
		System.out.println("First Child Column "+page.locator("tr:nth-child(4)").locator("td").count());
		
		// Total column count
		System.out.println("Total Column count : "+page.locator("tr:nth-child(4)").locator("td").count());
		
		//Total Cell count
		System.out.println(" Total Cell  "+page.locator("td").count());
		
		// Verify column Text
		System.out.println("cell text:-- "+page.locator("tr:nth-child(4)").locator("td:nth-child(4)").innerText());
		assertThat(page.locator("tr:nth-child(4)").locator("td:nth-child(4)")).hasText("For Illness");
		
		// Total table Text print(used lambda)
		//page.locator("td").allInnerTexts().forEach(text -> System.out.println(text));
		/*
		//Print Table Header
		System.out.println("----------------------Table Caption-----------------------------------------");
		System.out.println("\t\t\t\t\t"+page.locator("#divimg > div > h2:nth-child(8)").innerText());
		//Total Table Header print
		page.locator("#divimg > div > table:nth-child(8) > tbody > tr:first-child").allInnerTexts().forEach( text  -> System.out.print( text ));
		 Thread.sleep(2000);
		 
		//Total Table text print
		page.locator("#divimg > div > table:nth-child(9) > tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		
		// Verify Pre-formatted text //h2[text()='Welcome Test ']
		String welcomeMsg = page.textContent("//h2[text()='Welcome Test ']");
		if (welcomeMsg.contains("Welcome Test "))
			System.out.println("Employee Test2 is Pass");
		else
			System.out.println("Employee Test2 is Fail");
		*/
		/*page.locator(
				"body > div.fw-container > div.fw-header.ad > div.nav-wrapper > div.nav-search > div.nav-item.i-download > a")
				.click();
		page.locator("body > div.fw-container > div.fw-body > div > ul > li:nth-child(2)").click();
		Download file = page.waitForDownload(() -> {
			page.locator("//a[@class='site-btn large']").click();
		});
		file.saveAs(Paths.get("C:\\java\\DataTables.zip"));*/
	}

}
