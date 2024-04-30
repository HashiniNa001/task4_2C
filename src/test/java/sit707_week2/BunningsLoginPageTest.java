package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BunningsLoginPageTest {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bunnings.com.au/login");
    }
    
    @Test
	public void testStudentIdentity() {
    	String studentId = "s223021831";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "N G H Madushani";
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testSuccessfulLogin() {
        WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        usernameInput.sendKeys("hashininanayakkara001@gmail.com");
        passwordInput.sendKeys("Hashini@#$123");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }

    @Test
    public void testFailedLoginIncorrectPassword() {
    	WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        usernameInput.sendKeys("hashininanayakkara001@gmail.com");
        passwordInput.sendKeys("abc@#$123");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }

    @Test
    public void testFailedLoginIncorrectUsername() {
    	WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        usernameInput.sendKeys("abc@gmail.com");
        passwordInput.sendKeys("Hashini@#$123");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }

    @Test
    public void testFailedLoginBothIncorrect() {
    	WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        usernameInput.sendKeys("abc@gmail.com");
        passwordInput.sendKeys("abc@#$123");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }
}

