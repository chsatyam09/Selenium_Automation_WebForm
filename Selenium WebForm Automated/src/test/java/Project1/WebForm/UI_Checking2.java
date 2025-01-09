
package Project1.WebForm;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UI_Checking2 {

    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
        	 String expectedUrl = "https://www.selenium.dev/selenium/web/web-form.html";

            // Open the URL and maximize the browser window
            driver.get( expectedUrl );
            driver.manage().window().maximize();
            Thread.sleep(4000);

            validateUrl(driver,  expectedUrl );
            validateTitle(driver, "Web form");
            interactWithFormElements(driver);
            interactWithAdditionalElements(driver);

            // Submit the form
            submitForm(driver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void validateUrl(WebDriver driver, String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Test Passed: The page URL matches the expected URL.");
        } else {
            System.out.println("Test Failed: The page URL doesn't match!");
            System.out.println("Expected: " + expectedUrl);
            System.out.println("Actual: " + currentUrl);
        }
    }

    private static void validateTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed: The page Title matches the expected Title.");
        } else {
            System.out.println("Test Failed: The page Title doesn't match!");
            System.out.println("Expected: " + expectedTitle);
            System.out.println("Actual: " + actualTitle);
        }
    }

    private static void interactWithFormElements(WebDriver driver) throws InterruptedException {
        // Interact with text input
        driver.findElement(By.id("my-text-id")).sendKeys("My Name is Satyam");
        Thread.sleep(2000);

        // Interact with password input
        driver.findElement(By.xpath("//input[@name='my-password']")).sendKeys("Satyam1234");
        Thread.sleep(2000);

        // Interact with textarea
        WebElement textarea = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
        textarea.sendKeys("This is a demo project aimed at validating the functionality of the specified website using my expertise in automation testing.");
        Thread.sleep(2000);

        // Interact with readonly input
        String expectedText = "Readonly input";
        WebElement readOnlyInput = driver.findElement(By.xpath("//input[@name='my-readonly']"));
        String actualText = readOnlyInput.getAttribute("value");
        assertEquals(expectedText, actualText, "The readonly input text doesn't match!");
        Thread.sleep(2000);
    }

    private static void interactWithAdditionalElements(WebDriver driver) throws InterruptedException {
        // Interact with dropdown
        WebElement dropdown = driver.findElement(By.className("form-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");
        Thread.sleep(2000);

        // Interact with datalist
        WebElement datalistInput = driver.findElement(By.className("form-control"));
        datalistInput.sendKeys("New York");
        Thread.sleep(2000);

        // Validate datalist value
        String enteredValue = datalistInput.getAttribute("value");
        if ("New York".equals(enteredValue)) {
            System.out.println("Value entered correctly in the datalist input.");
        } else {
            System.out.println("Failed to enter the correct value in the datalist input.");
        }
        Thread.sleep(2000);

        // Upload a file
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("/Users/satyamchaudhary/Desktop/Valuable/Resume/Satyam_Resume_Latest.pdf");

        // Interact with checkbox
        driver.findElement(By.id("my-check-1")).click();

        // Interact with radio button
        driver.findElement(By.id("my-radio-2")).click();

        // Interact with color picker
        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        colorPicker.sendKeys("#ff5733");
        System.out.println("Selected color: " + colorPicker.getAttribute("value"));

        // Interact with date picker
        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.sendKeys("2023-07-08");

        // Interact with range slider
        WebElement rangeSlider = driver.findElement(By.name("my-range"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=8;", rangeSlider);
    }

    private static void submitForm(WebDriver driver) {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Form submitted successfully!");
    }
}

