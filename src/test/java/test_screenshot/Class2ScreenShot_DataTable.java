package test_screenshot;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Class2ScreenShot_DataTable {

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
		//page.navigate("https://datatables.net");
		//String title2=page.title();
		//assertThat(page.title()).hasText("DataTables example - DataTables events");
		
		page.navigate("https://datatables.net/manual/");
		//Get page title
		System.out.println(page.title());
		//Verify Manual page title
		assertThat(page.locator(" //h1[text()='Manual']")).hasText("Manual");
		//screen shot
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/DataTables_Page.png")));
		Thread.sleep(1000);
		//click Data
		page.locator("body > div.fw-container > div.fw-nav > div.nav-main > ul > li.active.sub > ul > li:nth-child(2) > a").click();
		//Verify Data page title
		System.out.println(page.title());
		assertThat(page.locator(" //h1[text()='Data']")).hasText("Data");
		
		//Click Orthogonal Data
		page.locator("body > div.fw-container > div.fw-nav > div.nav-main > ul > li.sub-active.sub > ul > li.active.sub > ul > li:nth-child(1) > a").click();		
		//Verify Orthogonal Data page title
		System.out.println(page.title());
		assertThat(page.locator("//h1[text()='Orthogonal data']")).hasText("Orthogonal data");
		
		//go back 
		page.goBack();
		System.out.println(page.title());
		assertThat(page.locator(" //h1[text()='Data']")).hasText("Data");

		//click Technical Notes
		page.locator("body > div.fw-container > div.fw-nav > div.nav-main > ul > li.sub-active.sub > ul > li:nth-child(13) > a").click();
		System.out.println(page.title());
		//Verify Technical Notes page title
		assertThat(page.locator("body > div.fw-container > div.fw-nav > div.nav-main > ul > li.sub-active.sub > ul > li:nth-child(13) > a")).hasText("Technical notes");
		
		//click invalid JSON response
		page.locator("body > div.fw-container > div.fw-body > div > div.category-items > div:nth-child(1) > h3 > a").click();
		System.out.println(page.title());
		
		//download DataTable file
		page.locator("body > div.fw-container > div.fw-header > div.nav-wrapper > div.nav-search > div.nav-item.i-download > a").click();
		page.locator("body > div.fw-container > div.fw-body > div > ul > li:nth-child(2)").click();
		Download file = page.waitForDownload(() -> {page.locator("//a[@class='site-btn large']").click();});
		//Save file in C drive 
		file.saveAs(Paths.get("C:\\Java\\webpage\\DataTables.zip"));
		
	/*	Thread.sleep(2000);
		for (int i = 0; i < 1; i++) {
			//page.press("//*[@id=\"input__text2\"]", "ArrowUp");
			page.press("//select[@name='example_length']", "ArrowDown");
		}		
		Thread.sleep(1000);
		//page.locator("//td[text()='Ashton Cox']").click();
		//page.locator("//input[@type='search']").fill("Bradley Greer");
		
		// Web Table Handling
		// Total Row count
		System.out.println("Total Row "+page.locator("#example>tbody>tr").count());
		
		// First-child column count
		System.out.println("First Child Column "+page.locator("tr:first-child").locator("td").count());
		
		// Total column count
		System.out.println("Column count of Heading "+ page.locator(".dataTable>thead>tr>th").count());
		System.out.println("Total Column "+page.locator("tr:nth-child(2)").locator("td").count());
		
		//Total Cell count
		System.out.println("Total Cell  "+page.locator("td").count());
		//find text in 10th Row and 2 col
		System.out.println( page.locator("//tr[10]/td[2]").innerText() );
		//find text in 3th Row and 2 col
		System.out.println( page.locator("//tr[3]/td[2]").innerText() );
		
		// Verify column Text
		//System.out.println("cell text:-- "+page.locator("tr:first-child").locator("td:nth-child(8)").innerText());

		assertThat(page.locator("tr:nth-child(10)").locator("td:nth-child(2)")).hasText("Senior Javascript Developer");
		
		// Total table Text print(used lambda)
		//page.locator("td").allInnerTexts().forEach(text -> System.out.println(text));		
		//Print Table Header
		System.out.println("----------------------Table Caption-----------------------------------------");
		//System.out.print(page.locator("#th").innerText());
		//Total Table Header print
		page.locator("#example>thead").allInnerTexts().forEach( text  -> System.out.print("\t" +text ));
		 
		//Total Table text print
		page.locator("#example>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		//Total Table Footer print
		page.locator(".dataTable>tfoot").allInnerTexts().forEach(text -> System.out.print(text));
		
		*/		
		// Verify Pre-formatted text //h2[text()='Welcome Test ']//#text__code > div > h2
//		String welcomeMsg = page.textContent("//h2[text()='Welcome Test ']");
//		if (welcomeMsg.contains("Welcome Test "))
//			System.out.println("Test2 is Pass");
//		else
//			System.out.println("Test2 is Fail");

	}

}
