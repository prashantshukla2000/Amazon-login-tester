package Actionclasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Amazonloginpageactionclass {
	
	WebDriver driver =null;
	String driverpath="C:\\Users\\prashant.bhushan\\Downloads\\ChromeDriver\\ChromeDriver.exe";
//scenario-1	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		
		  System.setProperty("webdriver.chrome.driver", driverpath);
		   driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.com");
		  	  
	}

	@When("^user enters correct email and password$")
	public void user_enters_correct_email_and_password() {
		
		driver.findElement(By.id("nav-link-accountList")).click();
		  driver.findElement(By.id("ap_email")).sendKeys("7007101992");
		  driver.findElement(By.id("continue")).click();
	      driver.findElement(By.id("ap_password")).sendKeys("27062000");
	      driver.findElement(By.id("signInSubmit")).click();
	}

	@Then("^user gets confirmation$")
	public void user_gets_confirmation()  {
		
		  String u= driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		  if(u.equals("Hello, Prashant"))
		  {
			  System.out.println("Test case Passed");
		  }else {
			  System.out.println("Test case failed");
		  }
	    driver.close();
	}
	
//	scenario-2
//	@Given("^user is on the login page$")
//	public void user_is_on_the_login_page() {
//		
//		  System.setProperty("webdriver.chrome.driver", driverpath);
//		  driver = new ChromeDriver();
//		  driver.manage().window().maximize();
//		  driver.get("https://www.amazon.com");
//	}    
//	When user is on the signup page
//	And user enters details
	
	@When("^user is on the signup page$")
	public void user_is_on_the_signup_page () {
		
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("createAccountSubmit")).click();////*
		String z=driver.findElement(By.className("a-spacing-small")).getText();
		 System.out.println(z);
		if(z.equals("Create account"))
		  {
			  System.out.println("On the signup page");
		  }else {
			  System.out.println("failed to log on to the signup page");
		  }
	
	    
	}
	
	@And("^user enters details$")
	public void user_enters_details() {
		
		driver.findElement(By.id("ap_customer_name")).sendKeys("Prashant");
		driver.findElement(By.id("ap_email")).sendKeys("12345678");
		driver.findElement(By.id("ap_password")).sendKeys("qwerty");
		driver.findElement(By.id("ap_password_check")).sendKeys("qwerty");
		driver.findElement(By.id("continue")).click();
		
	}
	

	@Then("^user gets approval$")
	public void user_gets_approval()  {
		//*
		 // String u= driver.findElement(By.xpath("[@id=\"cvf-page-content\"]/div/div/div/div[1]/span")).;
		//String u= driver.findElement(By.xpath("[@id=\"cvf-page-content\"]/div/div/div/div[1]/span")).getText();
		 // if(u.equals("Solve this puzzle to protect your account"))
		//By.linkText("Solve Puzzle")) != null)
		if(driver.findElement(By.className("a-size-large")) != null)
		  {
			  System.out.println("Test case Passed");
		  }else {
			  System.out.println("Test case failed");
		  }
		  driver.close();
	    
	}
	//page_heading = driver.find_element_by_tag_name('h1')
	//click_here_link = driver.find_element_by_link_text('Click Here')

 
	
}