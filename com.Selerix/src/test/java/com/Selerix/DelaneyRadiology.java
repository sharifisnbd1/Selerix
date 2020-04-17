package com.Selerix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class DelaneyRadiology {
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList <Object[]>testData=TestUtil.getDataFromExcel();
		return testData.iterator();
		
	
}
@Test(dataProvider="getTestData")
public void enrollments(String userID, String password, String basePremium, String yearStayed, String stateOfBirth, String countryOfBirth,String pinFoeSign1,String pinForSign2) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shari\\eclipse-workspace\\com.Selerix\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://uat.benselect.com/Enroll/Login.aspx");
	Thread.sleep(10000);
	
	//Login
	driver.findElement(By.xpath("//input[@id='LoginCtrl_txtEmployeeIdent']")).sendKeys("userID"); //adam
	driver.findElement(By.xpath("//input[@id='LoginCtrl_txtPINorKeyCode']")).sendKeys("password"); // 11111
	Thread.sleep(20000);
	driver.findElement(By.xpath("//input[@id='LoginCtrl_cmdLogon']")).click();
	
	//Go to benefits 
	driver.findElement(By.xpath("//div[@class='icon']//a[contains(text(),'ContinuON Income Solutions II- Stand Alone')]")).click();
	Thread.sleep(20000);
	
	Select selectCnsent=new Select (driver.findElement(By.xpath("//select[@id='bodyContent_ucMain_m_ddFeatures_0']")));
	selectCnsent.selectByValue("Yes");
	Thread.sleep(5000);
	
	Select selectTobbaco =new Select(driver.findElement(By.xpath("//select[@id='bodyContent_ucMain_m_ddFeatures_1']")));
	selectTobbaco.selectByValue("No");
	Thread.sleep(5000);
	
	Select selectWork=new Select(driver.findElement(By.xpath("//select[@id='bodyContent_ucMain_m_ddFeatures_2']")));
	selectWork.selectByValue("Yes");
	Thread.sleep(5000);
	
	Select selectBenefit=new Select(driver.findElement(By.xpath("//select[@id='bodyContent_ucMain_m_ddFeatures_3']")));
	selectBenefit.selectByValue("Yes");
	Thread.sleep(5000);
	
	driver.findElement(By.id("bodyContent_ucMain_txtBenefitAmounts")).clear();
	driver.findElement(By.id("bodyContent_ucMain_txtBenefitAmounts")).sendKeys("basePremium"); // Base Premium
	
	driver.findElement(By.xpath("//input[@id='bodyContent_ucMain_C6L']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_ucMain_OCC']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_ucMain_RSE']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_ucMain_CAT']")).click();
	
	Select selectCAT=new Select(driver.findElement(By.xpath("//select[@id='bodyContent_ucMain_CATBenefit']")));
	selectCAT.deselectByValue("10000"); //CAT benefit selection 
	
	// Click Next after benefits selection
	driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Next_cmdButton_Next']")).click();
	
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_CurrentAddress_cd5efa78-0d35-4b37-bdee-a9402365bcc5']")).sendKeys("yearStayed");// How long stayed in the address
	
	Select selectSOB=new Select(driver.findElement(By.xpath("//select[@id='bodyContent_MainCtrl_6465_GSI_StateofBirth_cd5efa78-0d35-4b37-bdee-a9402365bcc5_6465_GSI_StateofBirth_cd5efa78-0d35-4b37-bdee-a9402365bcc5_state']")));
	selectSOB.selectByValue("stateOfBirth");// Select State of Birth
	
	//List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='bodyContent_MainCtrl_6465_GSI_StateofBirth_cd5efa78-0d35-4b37-bdee-a9402365bcc5_6465_GSI_StateofBirth_cd5efa78-0d35-4b37-bdee-a9402365bcc5_state']")));
	//for (WebElement element:myList)
	  //  if(element.getText().contains("TN"));
	     //   element.click();
	
	driver.findElement(By.xpath("//select[@id='bodyContent_MainCtrl_6465_GSI_StateofBirth_cd5efa78-0d35-4b37-bdee-a9402365bcc5_6465_GSI_StateofBirth_cd5efa78-0d35-4b37-bdee-a9402365bcc5_state']")).sendKeys("countryOfBirth");// Enter country of birth
	
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_Citizen_cd5efa78-0d35-4b37-bdee-a9402365bcc5_0']")).click();
	driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Next_cmdButton_Next']")).click();
	Thread.sleep(5000);
	
	//Type of Business
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_BusinessType_cd5efa78-0d35-4b37-bdee-a9402365bcc5']")).sendKeys("Medical");//Type of Business
	
		
	// Other coverrage replacement informations 
	
	driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Next_cmdButton_Next']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_Eligible_cd5efa78-0d35-4b37-bdee-a9402365bcc5_1']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_Other_DI_Insurance_cd5efa78-0d35-4b37-bdee-a9402365bcc5_1']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_CAT_DI_Rider_cd5efa78-0d35-4b37-bdee-a9402365bcc5_1']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_CAT_DI_Rider_cd5efa78-0d35-4b37-bdee-a9402365bcc5_1']")).click();
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_BenefitsReceived_cd5efa78-0d35-4b37-bdee-a9402365bcc5_1']")).click();
	
	//Mutual Agreement
	driver.findElement(By.xpath("//input[@id='bodyContent_MainCtrl_6465_GSI_Mutual_Agreement_cd5efa78-0d35-4b37-bdee-a9402365bcc5_0']")).click();
	driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Next_cmdButton_Next']")).click();
	
	//Autorization to Insurance
	driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Next_cmdButton_Next']")).click();
	
	//Confirm
		driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Next_cmdButton_Next']")).click();
		driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Next_cmdButton_Next']")).click();
	Thread.sleep(5000);
	
	//Sign Form-1
	driver.findElement(By.xpath("//input[@id='txtPIN_ctl00_bodyContent_SignaturePad']")).sendKeys("pinFoeSign1");//PIN 11111
	driver.findElement(By.xpath("//input[@id='SubmitBtn_ctl00_bodyContent_SignaturePad']")).click();
	
	//Sign Form-2
	driver.findElement(By.xpath("//input[@id='txtPIN_ctl00_bodyContent_SignaturePad']")).sendKeys("pinFoeSign2");//PIN 11111
	driver.findElement(By.xpath("//input[@id='SubmitBtn_ctl00_bodyContent_SignaturePad']']")).click();
	
	//Logout
	driver.findElement(By.xpath("//button[@id='MainBottomNavigation_0_Logout_cmdButton_Logout']")).click();
	
	driver.close();
	
}


	
}
	


