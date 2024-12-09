package FAST;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;



public class Login {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            long startTime  = System.currentTimeMillis();
            page.navigate("");
            page.locator("input[name='UserLogin[username]']").fill("");
            page.locator("input[name='UserLogin[password]']").fill("");
            page.locator("button:has-text('Login')").click();

            page.waitForLoadState();
            long endTime = System.currentTimeMillis();

            long duration = endTime - startTime;

            System.out.println("Login performance: " + duration + " ms");
           // boolean isLoggedIn = page.locator("text=Home").isVisible();
            //if (isLoggedIn) {
           //     System.out.println("Login Test Passed: User logged in successfully.");
            //} else {
            //    System.out.println("Login Test Failed: User login unsuccessful.");

            //page.locator("text=Home").click();
            page.waitForLoadState();
            page.locator("text=Your Catalog").click();
            page.waitForLoadState();
            page.locator("//span[@class='title' and text()='Inventory']").click();
            page.waitForLoadState();
            page.locator("//span[@class='title' and text()='Request For Quote']").click();
            page.waitForLoadState();
        }
    }
}
