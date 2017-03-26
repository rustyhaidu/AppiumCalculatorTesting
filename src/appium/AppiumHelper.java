package appium;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AppiumHelper {	
	
	private DesiredCapabilities desiredCapabilities;	
	
	public void setDesiredCapabilities(String deviceName, String androidVersion,String platformName, String appPackage, String Activity){
		desiredCapabilities = new DesiredCapabilities();		
		desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		desiredCapabilities.setCapability("deviceName", deviceName);
		desiredCapabilities.setCapability("platformVersion", androidVersion);
		desiredCapabilities.setCapability("platformName", platformName);		
		desiredCapabilities.setCapability("appPackage", appPackage);
		desiredCapabilities.setCapability("appActivity", Activity);
	}
	public DesiredCapabilities getDesiredCapabilities(){
		return desiredCapabilities;
	}
	
}
