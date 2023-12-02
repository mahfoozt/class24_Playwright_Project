package test_table;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class3_Html_Table {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		//playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));
		Page page;
		page = browser.newPage();
		page.navigate("file:///C:/Java/SDET_Class/New_html-all.html");
		//Get page title
		System.out.println(page.title());
		Thread.sleep(1000);
		
		// Web Table Handling
		// Total Row count
		System.out.println("Total Row count : "+page.locator(".dataTable>tbody").locator("tr").count());
		
		//Total Column count
		System.out.println("Total Column count : "+page.locator(".dataTable>tbody>tr").locator("td").count());
		
		// First-child column count
		System.out.println("First Child Column count: "+page.locator(".dataTable>tbody").locator("tr:first-child").locator("td").count());
		
		// Second-child column count
		System.out.println("Second Child Column count :"+page.locator(".dataTable>tbody").locator("tr:nth-child(2)").locator("td").count());
		
		// Verify column Text
		//assertThat(page.locator(".dataTable>tbody").locator("tr:first-child").locator("td:nth-child(2)")).hasText("Table Cell 2");
		
		// Total table Text print(used lambda)
		//page.locator(".dataTable>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		//Print Table Header
		System.out.println("----------------------Table Caption-----------------------------------------");
		System.out.println(page.locator("//h2[text()='Tabular data']").innerText());
		//Total Table Header print
		page.locator(".dataTable>thead").allInnerTexts().forEach( text  -> System.out.print( text ));
		 
		//Total Table text print
		page.locator(".dataTable>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		//Total Table Footer print
		page.locator(".dataTable>tfoot").allInnerTexts().forEach(text -> System.out.print(text));
		
		//find text in 3rd Row and 2 col is "Table Cell 8"
		System.out.println("-----Print Text in 2rd Row and 3rd col is \"Table Cell 8\"------------------");
	 
		System.out.println( page.locator("//tr[2]/td[3]").innerText() );	

	}

}
