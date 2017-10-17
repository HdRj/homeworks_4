package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private String addressPage="http://prestashop-automation.qatestlab.com.ua";
    private By allProdLink=By.xpath("//a[@class='all-product-link pull-xs-left pull-md-right h4']");

    public void open(){
        driver.get(addressPage);
    }

    public void clickAllProd(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(allProdLink));
        driver.findElement(allProdLink).click();
    }




}
