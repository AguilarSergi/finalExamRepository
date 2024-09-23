import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import bsh.ParseException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Examen {
	public static AppiumDriver driver;
	
  @Test
  public void test() throws InterruptedException, ParseException, IOException {
	  DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android"); 
		caps.setCapability("appium:deviceName", "Pixel_5"); 
		caps.setCapability("appium:automationName", "UiAutomator2"); 
		caps.setCapability("appium:udid", "emulator-5554"); 
		String appURL = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
				File.separator + "resources" + File.separator + "example.apk";
		caps.setCapability("appium:app", appURL); 
		String serverURL = "http://0.0.0.0:4723"; 
		URL url = new URL(serverURL);
		AndroidDriver driver = new AndroidDriver(url, caps);
	  	driver.findElement(AppiumBy.id("android:id/button1")).click();
	  	
	  	menuButton(driver);
		takeScreenshot(driver);
		button1(driver);
		takeScreenshot(driver);
		button2(driver);
		takeScreenshot(driver);
		button3(driver);
		takeScreenshot(driver);
		text1(driver);
		takeScreenshot(driver);
		checkbox2(driver);
		takeScreenshot(driver);
		checkbox3(driver);
		takeScreenshot(driver);
		checkbox1(driver);
		takeScreenshot(driver);
	
		
  }
  private static void menuButton(AppiumDriver driver) throws InterruptedException {
		WebElement menu = driver.findElement(AppiumBy.id("at.markushi.reveal:id/action"));
		System.out.println("The hamburguer menu is displayed?: " + menu.isDisplayed());
		Thread.sleep(1500);
	}
	private static void button1(AppiumDriver driver) throws InterruptedException {
		WebElement button1 = driver.findElement(AppiumBy.id("at.markushi.reveal:id/btn_1"));
		System.out.println("The button 1 is displayed?: " + button1.isDisplayed());
		//assertEquals(button1.isDisplayed(),true);
		Thread.sleep(1500);
	}
	private static void button2(AppiumDriver driver) throws InterruptedException {
		WebElement button2 = driver.findElement(AppiumBy.id("at.markushi.reveal:id/btn_2"));
		System.out.println("The button 2 is displayed?: " + button2.isDisplayed());
		Thread.sleep(1500);
	}
	private static void button3(AppiumDriver driver) throws InterruptedException {
		WebElement button3 = driver.findElement(AppiumBy.id("at.markushi.reveal:id/btn_3"));
		System.out.println("The button 3 is displayed?: " + button3.isDisplayed());
		Thread.sleep(1500);
	}
	private static void text1(AppiumDriver driver) throws InterruptedException {
		WebElement text1 = driver.findElement(AppiumBy.id("at.markushi.reveal:id/slow_motion"));
		System.out.println("The first text is: " + text1.getAttribute("text"));
		Thread.sleep(1500);
	}
	private static void checkbox2(AppiumDriver driver) throws InterruptedException {
		WebElement checkbox2 = driver.findElement(AppiumBy.id("at.markushi.reveal:id/enable_reveal"));
		System.out.println("The reveal color view checkbox is enabled?: " + checkbox2.getAttribute("checked"));
		Thread.sleep(1500);
	}
	private static void checkbox3(AppiumDriver driver) throws InterruptedException {
		WebElement checkbox3 = driver.findElement(AppiumBy.id("at.markushi.reveal:id/enable_actions"));
		System.out.println("The action view checkbox is enabled?: " + checkbox3.getAttribute("checked"));
		Thread.sleep(1500);
	}
	private static void checkbox1(AppiumDriver driver) throws InterruptedException {
		WebElement checkbox1 = driver.findElement(AppiumBy.id("at.markushi.reveal:id/slow_motion"));
		System.out.println("The slow motion checkbox is enabled?: " + checkbox1.getAttribute("checked"));
		checkbox1.click();
		driver.findElement(AppiumBy.id("at.markushi.reveal:id/btn_3")).click();
		Thread.sleep(3000);
	}
	private static void takeScreenshot(AppiumDriver driver) throws ParseException, IOException {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("C:\\Users\\saguilarflores\\Documents\\MobileTesting Course\\test2\\" + getDate() + ".png"));
	}
	public static String getDate() throws ParseException {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy-hh-mm-ss");
		String todayForSS = formatter.format(today);
		//System.out.println("date: " + todayForSS);
		return todayForSS;
	}
}

