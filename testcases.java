package SingerSriLanka;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class testcases {
	    WebDriver driver;
	    WebDriverWait wait;

	    @Test(priority=1)
	    public void OepnApp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://www.singersl.com/");
	    }

	    @Test(priority=2)
	    public void testloginbuttonappeear() {
	    	
	        // Click on the login button
	        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"block-singer-account-menu\"]/ul/li[2]/a"));
	        loginButton.click();

	    }
	    
	        @Test(priority=3)
	        public void testvalidlogindetails() {
	        	 // Fill in login details
		        WebElement emailField = driver.findElement(By.id("email"));
		        emailField.sendKeys("priyankaweragoda72@gmail.com");
		        WebElement passwordField = driver.findElement(By.id("password"));
		        passwordField.sendKeys("priya@123456");
		        // Submit login
		        WebElement loginSubmitButton = driver.findElement(By.id("login-submit"));
		        loginSubmitButton.click();

		      
	        }
	        
	        @Test(priority = 4)
	        public void testsearchproduct() {
	            try {
	                // Search for a product
	                WebElement searchButton = driver.findElement(By.id("edit-search"));
	                searchButton.sendKeys("Samsung");
	                searchButton.sendKeys(Keys.ENTER);

	                // Wait for the product link to be clickable
	                WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung Galaxy A06 (4GB + 64GB) (Light Blue)")));

	                // Scroll into view
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productLink);

	                // Click on the product link
	                productLink.click();

	            } catch (TimeoutException e) {
	                System.out.println("Product link not found within the timeout period.");
	                throw e;
	            } catch (ElementClickInterceptedException e) {
	                System.out.println("Element not clickable, attempting JavaScript click.");
	                WebElement productLink = driver.findElement(By.linkText("Samsung Galaxy A06 (4GB + 64GB) (Light Blue)"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productLink);
	            }
	        }
	        
	        @Test(priority = 5)
	        public void testaddtocartbutton() {
	            try {
	                // Wait for the Add to Cart button to be present
	                WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit-order-now")));
	                
	                // Scroll the button into view
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
	                
	                // Wait for the button to be clickable
	                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

	                // Click the button
	                addToCartButton.click();
	            } catch (ElementClickInterceptedException e) {
	                System.out.println("Element not clickable, attempting JavaScript click.");
	                
	                // Fallback: Use JavaScript to click the button
	                WebElement addToCartButton = driver.findElement(By.id("edit-order-now"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
	            } catch (Exception e) {
	                System.out.println("Unexpected error while clicking Add to Cart: " + e.getMessage());
	                throw e;
	            }
	        }
	        @Test(priority=6)
	        public void testplaceorderbutton(){
	        	
	        // Place Order
	        WebElement placeOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'js-form-submit') and text()='Place Order']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
	        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));

	        try {
	            placeOrderButton.click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButton);
	        }
	        }



	
	        
	}


