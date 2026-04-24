package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSiteTest {

	public static void validateTitle(WebDriver driver) {
	    String title = driver.getTitle();
	    System.out.println("Page Title: " + title);

	    if (title.contains("Selenium")) {
	        System.out.println("Title validation passed");
	    } else {
	        System.out.println("Title validation failed");
	    }
	}
	
	public static void validateURL(WebDriver driver) {
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println("Current URL: " + currentUrl);

	    if (currentUrl.contains("selenium")) {
	        System.out.println("URL validation passed");
	    } else {
	        System.out.println("URL validation failed");
	    }
	}
	
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(3));

        driver.get("https://iamsandesh23.github.io/selenium.github.io/");
        driver.manage().window().maximize();
        
        validateURL(driver); 
        validateTitle(driver); 
        
        System.out.println("=== Demo Site Testing Started ===");

        // Username Field
        WebElement username = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        username.sendKeys("testuser");
        System.out.println("Username entered");

        // Password Field
        WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        password.sendKeys("12345");
        System.out.println("Password entered");

        Thread.sleep(2000);

        // Submit Button
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        submitButton.click();
        if (submitButton.isEnabled()) {
            submitButton.click();
            System.out.println("Button clicked");
        }

        Thread.sleep(2000);

        // Radio Button (Female)
        WebElement femaleRadio = driver.findElement(By.xpath("//input[@value='female']"));
        if (!femaleRadio.isSelected()) {
            femaleRadio.click();
            System.out.println("Female radio selected");
        }

        // Checkbox (Orange)
        WebElement checkbox = driver.findElement(By.xpath("//input[@value='orange']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Checkbox selected");
        }

        Thread.sleep(2000);

        // Enabled Button
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Button2']"));
        if (button2.isEnabled()) {
            button2.click();
            System.out.println("Enabled button clicked");
        }

        // Alert Handling
        WebElement alertBtn = driver.findElement(By.id("alert1"));
        alertBtn.click();
        System.out.println("Alert triggered");

        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        System.out.println("Alert handled");

        Thread.sleep(2000);

        // Text Validation
        String pageText = driver.findElement(By.tagName("body")).getText();

        if (pageText.contains("Selenium") || pageText.contains("Demo")) {
            System.out.println("Text validation passed");
        } else {
            System.out.println("Text validation failed");
        }

        // Close browser
        driver.quit();
        System.out.println("=== Test Completed ===");
    }
}