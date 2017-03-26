package appium;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomationTestsTest {
	
	private static final String LOCALHOST_URL = "http://127.0.0.1:4723/wd/hub";  
	private static AndroidDriver driver; 
	private static AppiumHelper appiumHelper;
	
	@BeforeClass
	public static void setCapabilities(){
		appiumHelper = new AppiumHelper();
		appiumHelper.setDesiredCapabilities("4300e60a97b1c039", "4.4.4", "Android", "com.test.calc", ".CalculatorActivity");
	}

	@Before
	public void runOnceBeforeEachTest() {
		try {
			driver = new AndroidDriver(new URL(LOCALHOST_URL), appiumHelper.getDesiredCapabilities());		
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}	
		
	}
	
	@After
	public void runOnceAfterEachTest(){
		driver.closeApp();
		driver.quit();
	}
	
	@Test
	public void testDefaultTopTextView() {		
		String textBoxTextTop = driver.findElement(By.id("com.test.calc:id/tv1")).getText();
		assertEquals(textBoxTextTop, "Islam_Hamdy");
	}
	
	@Test
	public void testDefaultBottomTextView() {		
		String textBoxTextTop = driver.findElement(By.id("com.test.calc:id/tv2")).getText();
		assertEquals(textBoxTextTop, "Sarah Osama");
	}

	@Test
	public void testTextBoxTopAfterTappingOnAddOnce() {
		driver.findElement(By.id("com.test.calc:id/add_b")).click();
		String textBoxTextTop = driver.findElement(By.id("com.test.calc:id/tv1")).getText();
		assertEquals(textBoxTextTop, "Bravo ya islam");
	}
	@Test
	public void testTextBoxBottomAfterTappingOnAddOnce() {
		driver.findElement(By.id("com.test.calc:id/add_b")).click();
		String textBoxTextBottom = driver.findElement(By.id("com.test.calc:id/tv2")).getText();
		assertEquals(textBoxTextBottom, "new number =1");
	}
	
	@Test
	public void testTextBoxTopAfterTappingOnSubOnce() {
		driver.findElement(By.id("com.test.calc:id/sub_b")).click();
		String textBoxTextTop = driver.findElement(By.id("com.test.calc:id/tv1")).getText();
		assertEquals(textBoxTextTop, "Islam_Hamdy");
	}
	@Test
	public void testTextBoxBottomAfterTappingOnSubOnce() {
		driver.findElement(By.id("com.test.calc:id/sub_b")).click();
		String textBoxTextBottom = driver.findElement(By.id("com.test.calc:id/tv2")).getText();
		assertEquals(textBoxTextBottom, "new number =-1");
	}
	
	@Test
	public void testTextBoxBottomAfterTappingOnAddTenTimes() {
		for(int i=0;i<10;i++){
			driver.findElement(By.id("com.test.calc:id/add_b")).click();
		}		
		String textBoxTextButtom = driver.findElement(By.id("com.test.calc:id/tv2")).getText();
		assertEquals(textBoxTextButtom, "new number =10");
	}
	
	@Test
	public void testTextBoxBottomAfterTappingOnSubTenTimes() {
		for(int i=0;i<10;i++){
			driver.findElement(By.id("com.test.calc:id/sub_b")).click();
		}		
		String textBoxTextButtom = driver.findElement(By.id("com.test.calc:id/tv2")).getText();
		assertEquals(textBoxTextButtom, "new number =-10");
	}
	
	@Test
	public void testTextBoxBottomAfterTappingOnAddTenTimesAndSubSevenTimes() {
		for(int i=0;i<10;i++){
			driver.findElement(By.id("com.test.calc:id/add_b")).click();
		}
		for(int i=0;i<7;i++){
			driver.findElement(By.id("com.test.calc:id/sub_b")).click();
		}
		String textBoxTextButtom = driver.findElement(By.id("com.test.calc:id/tv2")).getText();
		assertEquals(textBoxTextButtom, "new number =3"); // 10 - 7
	}

}
