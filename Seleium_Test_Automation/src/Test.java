
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import com.sun.jna.platform.FileUtils;

public class Test {
	
	static int i=0;
	static String firstName,lastName,emailId,phone,company,street1,street2,city,state,postcode,country,mobile,password,confirmPassword,imageName;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS );
		
		driver.get("https://phptravels.org/");
		
		
		
		for(i=1;i<=3;i++)
		{
			if(i==1)
			{
				firstName="Nimisha";
				lastName="Madhav";
				emailId="nimm.mad@gmail.com";
				phone="9878785612";
				company="XYZ company";
				street1="New street";
				street2="Lords road";
				city="Aravatagi";
				state="Karnataka";
				postcode="580007";
				country="India";
				mobile="";
				password="nimmy11_&";
				confirmPassword="nimmy11_&";
				imageName="testcase1";
			}
			else if(i==2)
			{
				firstName="Jojo";
				lastName="George";
				emailId="jojo@gmail.com";
				phone="9981324561";
				company="Chalmers";
				street1="New street";
				street2="New street";
				city="East Delhi";
				state="Delhi";
				postcode="110091";
				country="India";
				mobile="9981324561";
				password="password123";
				confirmPassword="";
				imageName="testcase2";
			}
			else if(i==3)
			{
				firstName="Rishi";
				lastName="Dhawal";
				emailId="rishidhawal@gmail.com";
				phone="9794563456";
				company="ABC Company";
				street1="old street";
				street2="old street";
				city="Gadag";
				state="Karnataka";
				postcode="582103";
				country="India";
				mobile="9794563456";
				password="grace1001_*";
				confirmPassword="grace1001_&";
				imageName="testcase3";
			}
		
		
			//Click Register
			driver.findElement(By.linkText("Register")).click();
			
			//firstName
			driver.findElement(By.xpath("//*[@id=\"inputFirstName\"]")).sendKeys(firstName);
			
			//lastName
			driver.findElement(By.xpath("//*[@id=\"inputLastName\"]")).sendKeys(lastName);
			
			//emailID
			driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys(emailId);
			
			//phone
			driver.findElement(By.xpath("//*[@id=\"inputPhone\"]")).sendKeys(phone);
			
			//company
			driver.findElement(By.xpath("//*[@id=\"inputCompanyName\"]")).sendKeys(company);
			
			//street1
			driver.findElement(By.xpath("//*[@id=\"inputAddress1\"]")).sendKeys(street1);
			
			//street2
			driver.findElement(By.xpath("//*[@id=\"inputAddress2\"]")).sendKeys(street2);
			
			//city
			driver.findElement(By.xpath("//*[@id=\"inputCity\"]")).sendKeys(city);
			
			//state
			driver.findElement(By.xpath("//*[@id=\"stateinput\"]")).sendKeys(state);
			
			//postcode
			driver.findElement(By.xpath("//*[@id=\"inputPostcode\"]")).sendKeys(postcode);
			
			//country
			Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id=\"inputCountry\"]")));
			drpCountry.selectByVisibleText(country);
			
			//mobileno
			driver.findElement(By.xpath("//*[@id=\"customfield2\"]")).sendKeys(mobile);
			
			//password
			driver.findElement(By.xpath("//*[@id=\"inputNewPassword1\"]")).sendKeys(password);
			
			//confirmpassword
			driver.findElement(By.xpath("//*[@id=\"inputNewPassword2\"]")).sendKeys(confirmPassword);
			
			//click register
			driver.findElement(By.xpath("//*[@id=\"frmCheckout\"]/p/input")).click();
			
			//screenshot
			Thread.sleep(1000);
			TakesScreenshot scrShot =((TakesScreenshot)driver);
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	        File DestFile=new File("E:\\workbench\\DT20173890672_Workspace\\Screenshot\\"+imageName+".png");
	        FileUtils.copyFile(SrcFile, DestFile);
			
		
		}
		
	}
	
	


}
