package loggingTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
    private static final Logger logger = LogManager.getLogger(TestSelenium.class);

    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
     // Log starting message
        logger.warn("Maximizing the browser window.");

        driver.manage().window().maximize();

        // Log starting message
        logger.info("Starting test...");

        // Open Linkedin
        driver.get("https://linkedin.com/");
        logger.info("LinkedIn Opened");

        // Clicking on signin button
        WebElement link = driver.findElement(By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']"));
        link.click();
        logger.info("Clicked on the 'Sign In' button");

        logger.info("Waiting 3 seconds before quiting the browser");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Log ending message
        logger.info("Test completed.");
        
        // Close the browser
        driver.quit();
    }
}
