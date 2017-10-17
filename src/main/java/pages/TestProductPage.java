package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestProductPage extends Page {
    public TestProductPage(WebDriver driver) {
        super(driver);
    }

    public TestProductPage(WebDriver driver, String nameProduct, int countProduct, double priceProduct){
        super(driver);
        this.nameProduct=nameProduct.toUpperCase();
        Integer cP=countProduct;
        this.countProductRU=cP.toString()+" Товары";
        this.countProductUA= cP.toString()+" од.";
        Double pP=priceProduct;
        this.priceProduct=pP.toString().replace('.',',')+" ₴";
    }

    private String nameProduct;
    private String countProductRU;
    private String countProductUA;
    private String priceProduct;

    private By nameTest=By.xpath("//h1[@class='h1']");
    private By countTest=By.xpath("//div[@class='product-quantities']/span");
    private By priceTest=By.xpath("//div[@class='current-price']/span");

    public boolean checkName() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(nameTest));

        if (!nameProduct.equals(driver.findElement(nameTest).getText())) {

            return false;
        }
        return true;
    }

    public boolean checkCount() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(countTest));
        if (countProductUA.equals(driver.findElement(countTest).getText())) {
            return true;
        }
        if (countProductRU.equals(driver.findElement(countTest).getText())) {
            return true;
        }
        return false;
    }

    public boolean checkPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(priceTest));
        if(!priceProduct.equals(driver.findElement(priceTest).getText())){
            return false;
        }
        return true;
    }

}
