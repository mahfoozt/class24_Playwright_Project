package test_table;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Class2_DataTable {

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
		page.navigate("https://datatables.net");
		//Get page title
		System.out.println(page.title());
		
		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			//page.press("//*[@id=\"input__text2\"]", "ArrowUp");
			page.press("//select[@name='example_length']", "ArrowDown");
		}
		
		Thread.sleep(1000);
		// Web Table Handling
		// Total Row count
		System.out.println("Total Row "+page.locator("tr").count());
		
		// First-child column count
		System.out.println("First Child Column "+page.locator("tr:first-child").locator("td").count());
		
		// Total column count
		System.out.println("Column count of Heading "+ page.locator(".dataTable>thead>tr>th").count());
		System.out.println("Total Column "+page.locator("tr:nth-child(2)").locator("td").count());
		
		//Total Cell count
		System.out.println("Total Cell  "+page.locator("td").count());
		
		// Verify column Text
	//	assertThat(page.locator("tr:first-child").locator("td:nth-child(2)")).hasText("Table Cell 2");
		
		// Total table Text print(used lambda)
		//page.locator("td").allInnerTexts().forEach(text -> System.out.println(text));
		
		//Print Table Header
		System.out.println("----------------------Table Caption-----------------------------------------");
		//System.out.print(page.locator("#th").innerText());
		//Total Table Header print
		page.locator(".dataTable>thead").allInnerTexts().forEach( text  -> System.out.print("\t" +text ));
		 
		//Total Table text print
		page.locator(".dataTable>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		//Total Table Footer print
		page.locator(".dataTable>tfoot").allInnerTexts().forEach(text -> System.out.print(text));
		
		
		// Verify Pre-formatted text //h2[text()='Welcome Test ']//#text__code > div > h2
//		String welcomeMsg = page.textContent("//h2[text()='Welcome Test ']");
//		if (welcomeMsg.contains("Welcome Test "))
//			System.out.println("Test2 is Pass");
//		else
//			System.out.println("Test2 is Fail");

	}

}
