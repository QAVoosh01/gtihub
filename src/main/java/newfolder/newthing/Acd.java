package newfolder.newthing;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Acd {
		WebDriver driver;
		@BeforeTest//fggfxcgfxg
		public void setup() {
			WebDriverManager.chromedriver().setup();
	        ChromeOptions opt = new ChromeOptions();
	      opt.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking","enable-automation"));
	    //    opt.addArguments("chrome.switches", "--disable-extensions --disable-notifications --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
	       // opt.addArguments("test-type");
	        opt.addArguments("chrome.switches", "--disable-extensions --disable-notifications --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --start-maximized"); 
	        Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        opt.setExperimentalOption("prefs", prefs);
	        driver = new ChromeDriver(opt);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		 @Test(priority = 1, groups = "Login Page")
		    void Login() throws InterruptedException {
		    	driver.get("https://vooshgrowapp.web.app/");
		        // Your test login page
		System.out.println("start Login by using vaild credentials");
		    	driver.manage().window().maximize();
		    	 driver.findElement(By.xpath("//input[@id='formBasicEmail']")).sendKeys("voosh@catapult.in");
		    	 driver.findElement(By.xpath("//input[@id='formBasicPassword']")).sendKeys("admin@catapult.io");
		    	 Thread. sleep(2000);
		    	 driver.findElement(By.xpath("//button[@type='submit']")).click();}
		    	 
		    //--------------filters---------------------------------
		 
		 @Test(priority = 2, groups = "Filter", enabled = true)
		   public void setfilters() throws InterruptedException {
	    	Thread.sleep(6000);

	    	driver.findElement(By.xpath("//span[@class='dropdown-style']//span[@class='filter-name'][normalize-space()='Channel']")).click();
		       Thread.sleep(2000);
		       
		       driver.findElement(By.xpath("//div[@class='content-page']//a[2]")).click();
		       Thread.sleep(2000);
		       
		       
		       driver.findElement(By.xpath("//span[@class='dropdown-style']//span[@class='filter-name'][normalize-space()='City']")).click();
		       Thread.sleep(2000);
		       
		       driver.findElement(By.xpath("//div[@class='show dropdown']//a[1]//*[name()='svg']//*[name()='path' and contains(@d,'M2 0a2 2 0')]")).click();
		 	  
		 	  Thread.sleep(1000);
		 	  
		 	 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			  
			   driver.findElement(By.xpath("//span[contains(text(),'Ann Arbor')]")).click();    
			       
			     driver.findElement(By.xpath("//span[@class='dropdown-style']//span[@class='filter-name'][normalize-space()='Locality']")).click(); // click on locality dropdown 
			          
			 driver.findElement(By.xpath("//div[@class='show dropdown']//a[1]")).click();
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//span[contains(text(),'Carpenter Rd')]")).click();
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("(//button[normalize-space()='Apply'])[1]")).click();
			 
		 }
		    	 
		    	//------------------------------start date --------------------------- 
		    	 @Test(priority = 3, enabled = true)
		  	   public void setdate() throws InterruptedException {
		      	 Thread.sleep(6000);	 
		  	    		String expectedDate = "10-November 2022"; //"10-October 2022"
		  	    		String emonthyear = expectedDate.split("-")[1];
		  	    		String edate = expectedDate.split("-")[0];
		  	    		System.out.println( edate+"***"+emonthyear);
		  	driver.findElement(By.xpath("//input[@placeholder='Start Date']")).click();
		  		
		  	driver.findElement(By.xpath("(//button[normalize-space()='Clear'])[1]")).click();
		  	 Thread.sleep(3000);	
		  	String cmonthyear = driver.findElement(By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1'])[2]")).getText().trim();
		  		System.out.println(cmonthyear);
		  		WebElement next;
		  	String c = cmonthyear;
		  	 String e = emonthyear;
		  	 while ( !c.equals(e)) {
		  	
		  		  Thread.sleep(3000);
		  		  next = driver.findElement(By.xpath("//div[@aria-label='Move backward to switch to the previous month.']"));
		  		  next.click();
		  		 c = driver.findElement(By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1'])[2]")).getText().trim(); 
		  			System.out.println(cmonthyear);
		  			
		  	 

		  	 Thread.sleep(2000);
		  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]//tbody[1]//td[text()="+edate+"]")).click();	
		  			
		  	Thread.sleep(5000);
		  } //sddsfsdf
		    	   
		//----------------enddate--------------------------
		 
		 String endedexpctedDate = "13-January 2023"; //"10-October 2022"
			String endedmonthyear = endedexpctedDate.split("-")[1];
			String endededate = endedexpctedDate.split("-")[0];
			System.out.println( endededate+"***"+endedmonthyear);
//			driver.findElement(By.xpath("//input[@placeholder='end Date']")).click();
			
//			driver.findElement(By.xpath("(//button[normalize-space()='Clear'])[1]")).click(); Thread.sleep(2000);	
			String endcmonthyear = driver.findElement(By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1'])[3]")).getText().trim();
			System.out.println(endcmonthyear);
			WebElement endnext;
		String endc = endcmonthyear;
		 String ende = endedmonthyear;
		 while ( !endc.equals(ende)) {
			 
			 Thread.sleep(2000);
			 endnext = driver.findElement(By.xpath("//div[@aria-label='Move forward to switch to the next month.']"));
			  endnext.click();
			 endc = driver.findElement(By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1'])[3]")).getText().trim(); 
				System.out.println("date selected end" + endcmonthyear);
		 }
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]//tbody[1]//td[text()="+endededate+"]")).click();
		    	 }
		    	 //------------------fetching the orders---------------------------total orders,Total_Amount,Net_payable,Avg_rating,online_Rate--------------------
		    	 @Test(priority = 3,enabled = true)
		    	 void Fetchthedata () throws InterruptedException {
		 Thread.sleep(4000);
		 WebElement Total_orders = driver.findElement(By.xpath("//div[@class='row-style']//span[@class='overview-box-amount']"));
		  String tot = Total_orders.getText();
			 System.out.println(" totalorders in Ovwerview page "+ tot);
			
			 Thread.sleep(4000);
			 WebElement Total_Amount = driver.findElement(By.xpath("(//div[@class='row-style']//div[@class='overview-box-amount'])[1]"));//(//div[@class='row-style']//div[@class='overview-box-amount'])[1]
			 String toa = Total_Amount.getText();
			 System.out.println(" Total Amount in Ovwerview page "+ toa);
			 
			 Thread.sleep(4000);
			 WebElement Net_Payable = driver.findElement(By.xpath("(//div[@class='row-style']//div[@class='overview-box-amount'])[3]"));
			 String Net_payab = Net_Payable.getText();
			 System.out.println(" Net Payable in Ovwerview page "+Net_payab);
			 
			 Thread.sleep(4000);
			 WebElement Avg_Rating = driver.findElement(By.xpath("(//div[@class='row-style']//div[@class='overview-box-amount'])[2]"));//(//div[@class='row-style']//div[@class='overview-box-amount'])[1]
			 String Avgr = Avg_Rating.getText();
			 System.out.println(" Avg Rating in Ovwerview page "+ Avgr);
			 
			 Thread.sleep(4000);
			 WebElement Online_Rate = driver.findElement(By.xpath("(//div[@class='row-style']//div[@class='overview-box-amount'])[4]"));//(//div[@class='row-style']//div[@class='overview-box-amount'])[1]
			 String Onlin_Rat = Online_Rate.getText();
			 System.out.println(" Online Rate in Ovwerview page "+ Onlin_Rat);
		    	 }
		    	 
		    	 @AfterTest
		    	 
		    	 void Quit() throws InterruptedException{
		    		 Thread.sleep(2000);
		    		 driver.close();
		    		 
		    		 
		    	 }
		    	 
		 
		 }    

	    
