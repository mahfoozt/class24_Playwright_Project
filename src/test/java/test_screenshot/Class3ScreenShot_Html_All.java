package test_screenshot;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Class3ScreenShot_Html_All {

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
		//verify Landing page 
		assertThat(page.locator("//h2[text()='Form elements']")).hasText("Form elements");
	
		// Input Text
		page.locator("#input__text").click();
		Thread.sleep(1000);
		page.locator("#input__text").fill("mahfooz");
		Thread.sleep(1000);
		//Input Password
		page.locator("#input__password").click();
		Thread.sleep(1000);
		page.locator("#input__password").fill("1234@56");
		//Input Email Address
		Thread.sleep(1000);
		page.locator("//input[@id='input__webaddress']").fill("https://github.com/mahfoozt/");
		Thread.sleep(1000);
		page.locator("//input[@id='input__emailaddress']").fill("mahfooz.murshalin@gmail.com");
		//Input Phone Numbers [Used Css ]
		Thread.sleep(1000);
		page.locator("#input__phone").fill("480-234-5678");
		//Type Search item
		Thread.sleep(1000);
		page.locator("//input[@id='input__search']").fill("Flower");
		//Input Number (Up and Down arrows)
		Thread.sleep(2000);
		//page.locator("//input[@id='input__text2']").fill("2");
		for(int i=0; i< 4; i++ ) {
			page.press("//input[@id='input__text2']","ArrowUp");
			//page.press("//input[@id='input__text2']","ArrowDown");
		}
		//screen shot
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/HtmlAll_Page.png")));
		Thread.sleep(1000);
		//verify Select menus
		assertThat(page.locator("#forms__select > legend")).hasText("Select menus");
		
		//verify Check boxes 
		assertThat(page.locator("#forms__checkbox > legend")).hasText("Checkboxes");
		
		
		
		

	}

}
