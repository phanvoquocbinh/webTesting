package testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkLabel {
	
	WebDriverWait explicitWait;
	
	WebElement phone, password;
	WebDriver driver;
	

	// Kiểm tra rằng website có thể truy cập và login bình thường
	@Test
	public void TC_01() {
		
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://pmc-ecm-store.dev.pharmacity.io/");
		 //driver.get("hhttps://www.pharmacity.vn/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//p[text()='Đăng nhập']")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[text()='Đăng nhập bằng mật khẩu']")).click(); 
		 WebElement phone, password;
		 phone=driver.findElement(By.xpath("//input[@name='phone']"));
		 password=driver.findElement(By.xpath("//input[@name='otp']"));
		 phone.sendKeys("0914497337"); password.sendKeys("123456789");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		 driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 System.out.println("TH1: Test Login thành công");
		 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 sleepInSecond(2);
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		 jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='DEAL SỐC MUA 2 TẶNG 2 - CHỈ TỪ 34.5000Đ/BỘ']")));
		 WebElement lable = driver.findElement(By.xpath("//img[contains(@src,'https://data-service.pharmacity.io/pmc-upload-media/development/pmc-ecm-core/promotions')]//ancestor::div//div[text()='Dụng cụ xét nghiệm nhanh kháng nguyên SARS-CoV-2 SureScreen Diagnostics Covid-19 Test Kit (Hộp 25 Test)']"));
		 lable.click();
	
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
