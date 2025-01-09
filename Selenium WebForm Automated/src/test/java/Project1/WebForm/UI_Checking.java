package Project1.WebForm;

import static org.testng.Assert.assertEquals;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UI_Checking {

    public static void main(String[] args) {
        // Define the URL to test
        String url = "https://www.selenium.dev/selenium/web/web-form.html";

        // Setup the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open the URL
            driver.get(url);
            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(4000);
            
            org.openqa.selenium.Dimension currentSize = driver.manage().window().getSize();
            System.out.println("Current window size: " + currentSize);

            // Validate the current URL against the expected URL
            String expectedUrl = "https://www.selenium.dev/selenium/web/web-form.html";
            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Test Passed: The page URL matches the expected URL.");
            } else {
                System.out.println("Test Failed: The page URL doesn't match!");
                System.out.println("Expected: " + expectedUrl);
                System.out.println("Actual: " + currentUrl);
            }
            

            // Validate the current Title against the expected Title
//            String expectedTitle = "Web form";
//            String actualTitle = driver.getTitle();
//            assertEquals(actualTitle, expectedTitle, "The page title doesn't match!");
            
            
            
         // Validate the current Title against the expected Title
            String expectedTitle = "Web form";
            String actualTitle = driver.getTitle();

            // Check if the actual title matches the expected title
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Test Passed: The page Title matches the expected Title.");
            } else {
                assertEquals(actualTitle, expectedTitle, "The page title doesn't match!");
            }


            // Locate and interact with the TextInput element by id
            driver.findElement(By.id("my-text-id")).sendKeys("My Name is Satyam");
            Thread.sleep(2000);

            // Locate and interact with the Password element by classname
            driver.findElement(By.xpath("//input[@name='my-password']")).sendKeys("Satyam1234");
            Thread.sleep(2000);

            // Locate and interact with the Textarea element by tag name
            WebElement textarea = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
            textarea.sendKeys("This is a demo project aimed at validating the functionality of the specified website using my expertise in automation testing.");
            Thread.sleep(2000);
            
            // Locate and interact with the   Readonly input element by Xpath
            String ActualText = "Readonly input" ;
            WebElement readText = driver.findElement(By.xpath("//input[@name='my-readonly']"));
            readText.getText();
            assertEquals(ActualText, readText);
            Thread.sleep(2000);
            
    
            // Locate and interact with the Dropdown element
            WebElement dropdown = driver.findElement(By.className("form-select"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Two");
            Thread.sleep(2000);

            // Locate and interact with the datalist element
            WebElement datalistInput = driver.findElement(By.className("form-control"));
            datalistInput.sendKeys("New York");
            Thread.sleep(2000);

            // Validate the entered value in the datalist
            String enteredValue = datalistInput.getAttribute("value");
            if ("New York".equals(enteredValue)) {
                System.out.println("Value entered correctly in the datalist input.");
            } else {
                System.out.println("Failed to enter the correct value in the datalist input.");
            }
            Thread.sleep(2000);

            // Upload a file using the file input element
            WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
            fileInput.sendKeys("/Users/satyamchaudhary/Desktop/Valuable/Resume/Satyam_Resume_Latest.pdf");

            // Automate the Checkbox element
            driver.findElement(By.id("my-check-1")).click();

            // Automate the Radio button element
            driver.findElement(By.id("my-radio-2")).click();

            // Locate and interact with the Color Picker element
            WebElement colorPicker = driver.findElement(By.name("my-colors"));
            colorPicker.sendKeys("#ff5733");

            // Validate the selected color value
            String selectedColor = colorPicker.getAttribute("value");
            System.out.println("Selected color: " + selectedColor);

            // Automate the Date Picker
            WebElement datePicker = driver.findElement(By.name("my-date"));
            datePicker.sendKeys("2023-07-08");

            // Locate and interact with the Range Slider
            WebElement rangeSlider = driver.findElement(By.name("my-range"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value=8;", rangeSlider);

            // Submit the form
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Confirmation message after submission
            System.out.println("Form submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
