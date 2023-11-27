package test_table;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class1_Micro {

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
		// Web Table Handling
		// Total Row count
		//System.out.println("Row count "+ page.locator("//h2[text()='Leave Satus']").locator(".table>tbody>tr>th").count());
		System.out.println("Row count of Reason "+ page.locator("//tr[1]/th[4]").count());
		// Web Table Handling
		// Total Row count
		System.out.println("Total Row "+page.locator("tr").count());
		
		// First-child column count
		//System.out.println("First Child Column "+page.locator("tr:first-child").locator("td").count());
		
		// Total column count
		System.out.println("Total Column "+page.locator("tr:nth-child(4)").locator("td").count());
		
		//Total Cell count
		System.out.println(" Total Cell  "+page.locator("td").count());
		
		// Verify column Text
	//	assertThat(page.locator("tr:first-child").locator("td:nth-child(2)")).hasText("Table Cell 2");
		
		// Total table Text print(used lambda)
		page.locator("td").allInnerTexts().forEach(text -> System.out.println(text));
		
/*		//Print Table Header
		System.out.println("----------------------Table Caption-----------------------------------------");
		System.out.println(page.locator("//h2[text()='Tabular data']").innerText());
		//Total Table Header print
		page.locator(".dataTable>thead").allInnerTexts().forEach( text  -> System.out.print( text ));
		 
		//Total Table text print
		page.locator(".dataTable>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		//Total Table Footer print
		page.locator(".dataTable>tfoot").allInnerTexts().forEach(text -> System.out.print(text));
		
		*/
		// Verify Pre-formatted text //h2[text()='Welcome Test ']//#text__code > div > h2
		String welcomeMsg = page.textContent("//h2[text()='Welcome Test ']");
		if (welcomeMsg.contains("Welcome Test "))
			System.out.println("Test2 is Pass");
		else
			System.out.println("Test2 is Fail");
		
	}

}
