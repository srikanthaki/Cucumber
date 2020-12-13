package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSearchSteps {
	
	WebDriver driver = SetUP.driver;
	
	ExtentReports extent;
    ExtentTest logger;
	
	@Given("^The user is already on the Amazon Home Page$")
    public void the_user_is_already_on_the_amazon_home_page() throws Throwable {
        
		driver.get("https://www.amazon.in/");
    }


    @When("^User click on search bar and type \"([^\"]*)\"$")
    public void user_click_on_search_bar_and_type_something(String productname) throws Throwable {
        
    	WebElement Search = driver.findElement(By.id("twotabsearchtextbox"));
    	Search.sendKeys(productname);
    	
   
    	WebElement Submit = driver.findElement(By.xpath("//*[@value='Go']"));
    	Submit.click();
    	
    	extent = new ExtentReports (System.getProperty("user.dir") +"/extent.html", false);
        
        logger = extent.startTest(productname);
        
        logger.log(LogStatus.PASS, "Search in the Amazon Search bar " +  productname);
    	
    }

    @Then("^User should be shown all the available \"([^\"]*)\" in the inventory$")
    public void user_should_be_shown_all_the_available_something_in_the_inventory(String productname) throws Throwable {
        
    	System.out.println("Then");
    	extent.endTest(logger);
        extent.flush();
        extent.close();
    }

    @But("^User should not see the \"([^\"]*)\"$")
    public void user_should_not_see_the_something(String excludedproduct) throws Throwable {
        
    	System.out.println("But");
    }


    
}

