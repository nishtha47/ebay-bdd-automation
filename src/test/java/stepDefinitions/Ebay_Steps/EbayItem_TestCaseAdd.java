package stepDefinitions.Ebay_Steps;


import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

public class EbayItem_TestCaseAdd {


	WebDriver driver;
    

    @Given("I open the browser and navigate to {string}")
    public void iOpenTheBrowserAndNavigateTo(String url) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        options.addArguments("--remote-allow-origins=*"); // Allow connections
        options.addArguments("--no-sandbox");            // Disable sandboxing
        options.addArguments("--disable-dev-shm-usage"); // Avoid resource issues
       // WebDriver driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver = new ChromeDriver(options);
    }

    @When("I search for {string}")
    public void iSearchFor(String item) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	//  Assert.assertTrue(ebayItemSearchPage.setSearch().isDisplayed());
      //  WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
       WebElement searchBox = driver.findElement(By.id("gh-ac"));
    	//driver.switchTo().frame("VLP Iframe");

       // WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='gh-ac-box2']//input[@id='gh-ac']")));
        
        searchBox.sendKeys("book");
    	  //ebayItemSearchPage.setSearch().sendKeys("book");
          Thread.sleep(2000);
       // searchBox.sendKeys(item);
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
    }

    @When("I click on the first item in the search results")
    public void iClickOnTheFirstItemInTheSearchResults() {
        WebElement firstItem = driver.findElement(By.cssSelector(".s-item__link"));
        firstItem.click();
    }

    @When("I add the item to the cart")
    public void iAddTheItemToTheCart() {
        WebElement addToCartButton = driver.findElement(By.id("atcRedesignId_btn"));
        addToCartButton.click();
    }

    @Then("the cart should display {string} item")
    public void theCartShouldDisplayItem(String expectedItemCount) {
        WebElement cartCount = driver.findElement(By.id("gh-cart-n"));
        String actualItemCount = cartCount.getText();
        assertEquals(expectedItemCount, actualItemCount);

        // Close the browser
        driver.quit();
    }
}
