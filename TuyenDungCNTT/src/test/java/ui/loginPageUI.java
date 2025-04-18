package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageUI {
    WebDriver driver;
    public loginPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buttonUserLogin() {return driver.findElement(By.id("btn-login"));}
    public String TextUserEmail() {return "login_email";}
    public WebElement TextUserPassword() {return driver.findElement(By.id("login_password"));}
    public WebElement buttonLogin() {return driver.findElement(By.id("form_btn-login"));}
    public WebElement userInfo() {return driver.findElement(By.xpath("//div[contains(@class,'user__info--name')]"));}

}
