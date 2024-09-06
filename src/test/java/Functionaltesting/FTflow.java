package Functionaltesting;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FTflow 
{
@Test
public void test() throws Throwable
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demo.dealsdray.com/");
	String date=new Date().toString().replace( " ", "_").replace(":", "_");
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prexo.mis@dealsdray.com");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("prexo.mis@dealsdray.com");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//button[@class='MuiButtonBase-root has-submenu compactNavItem css-46up3a']")).click();
	driver.findElement(By.xpath("//a[@href='/mis/orders']")).click();
	driver.findElement(By.xpath("(//div[@class='MuiBox-root css-0'])[2]")).click();
	WebElement ele=driver.findElement(By.xpath("//input[@class='MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5']"));
	ele.sendKeys("C:\\Users\\HP\\Downloads\\demo-data.xlsx");
	driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy']")).click();
	driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy']")).click();
	driver.switchTo().alert().accept();
	Thread.sleep(5000);
	TakesScreenshot tes=(TakesScreenshot)driver;
	File src = tes.getScreenshotAs(OutputType.FILE);
	File file=new File("./screenshot/HP_FT"+date+".png");
	FileHandler.copy(src, file);

}
}
