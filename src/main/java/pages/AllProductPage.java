package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AllProductPage extends Page {

    public AllProductPage(WebDriver driver) {
        super(driver);
    }

    public AllProductPage(WebDriver driver, String nameProduct){
        super(driver);
        testProduct=By.linkText(firstUpperCase(nameProduct));
        testProductFF=By.linkText(nameProduct);
    }

    private By testProduct;
    private By testProductFF;
    private By nextPage=By.xpath("//a[@class='next js-search-link']");


    public boolean clickTestProduct (){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(testProduct));
            driver.findElement(testProduct).click();

        } catch (Exception ee){
            try {
                wait.until(ExpectedConditions.elementToBeClickable(testProductFF));
                driver.findElement(testProductFF).click();
            } catch (Exception e) {
                try {
                    driver.findElement(nextPage).click();
                    clickTestProduct();
                } catch (Exception e1) {
                    System.out.println(e + " " + e1);
                    Reporter.log("Доданий продукт не вдалося знайти:(");
                    return false;

                }
            }
        }
        return true;
    }

    private String firstUpperCase(String word){
        if(word == null || word.isEmpty())
            return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }



}
