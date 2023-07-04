package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {

        // Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actionsMenu = new Actions(driver);
        actionsMenu.moveToElement(womenMenu).build().perform();

        // Mouse Hover on Tops
        WebElement Tops = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));
        Actions actionsTops = new Actions(driver);
        actionsTops.moveToElement(Tops).build().perform();


        // Click on Jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions actionsJackets = new Actions(driver);
        actionsJackets.moveToElement(jackets).click().build().perform();


        //Select Sort By filter “Product Name”

        WebElement sortBy = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"));
        Select productName = new Select(sortBy);
        productName.selectByVisibleText("Product Name");    //Select by visible text

        // Verify the products name display in alphabetical order





    }

    public void verifyTheSortByPriceFilter() {


        // Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actionsMenu = new Actions(driver);
        actionsMenu.moveToElement(womenMenu).build().perform();

        // Mouse Hover on Tops
        WebElement Tops = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));
        Actions actionsTops = new Actions(driver);
        actionsTops.moveToElement(Tops) .build().perform();

        // Click on Jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions actionsJackets = new Actions(driver);
        actionsJackets.moveToElement(jackets).click().build().perform();

        // Select Sort By filter “Price”
        WebElement sortByPrice = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"));
        Select productPrice = new Select(sortByPrice);
        productPrice.selectByVisibleText("Price");    //Select by visible text


        // Verify the products price display in Low to High





    }


    @After
    public void tearDown() {     // tear means close the browser
        //  closeBrowser();
    }
}
