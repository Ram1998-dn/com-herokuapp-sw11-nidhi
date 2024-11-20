package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // Enter "tomsmith" for the username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        // Enter "SuperSecretPassword!" for the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Click on the 'Login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Verify the text "Secure Area"
        WebElement secureAreaText = driver.findElement(By.xpath("//h2[contains(text(),'Secure Area')]"));
        assertTrue(secureAreaText.isDisplayed());

        // Click on the 'Logout' button
        WebElement logoutButton = driver.findElement(By.xpath("//a[@href = '/logout']"));
        logoutButton.click();

        // Verify the text 'You logged out of the secure area!'
        String actualMessage = driver.findElement(By.id("flash")).getText();
        String expectedMessage = "You logged out of the secure area!";
        Assert.assertEquals("Error message did not match", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Enter "tomsmith1" for the username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");

        // Enter "SuperSecretPassword!" for the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Click on the 'Login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        // Verify the error message "Your username is invalid!"
        String expectedMessage = "Your username is invalid!”";
        String errorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Error message did not match",expectedMessage,errorMessage);
   }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter "tomsmith" for the username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        // Enter "SuperSecretPassword" for the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword");

        // Click on the 'Login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        // Verify the error message "Your password is invalid!"
        String expectedMessage = "Your password is invalid!”";
        String errorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Error message did not match" , expectedMessage, errorMessage);
    }
}
