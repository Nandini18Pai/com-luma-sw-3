package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import static org.openqa.selenium.By.xpath;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //  Mouse Hover on Gear Menu
        WebElement gear = driver.findElement(xpath("//span[contains(text(),'Gear')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).build().perform();
        //  Click on Bags
        WebElement bags = driver.findElement(xpath("//span[contains(text(),'Bags')]"));
        actions.moveToElement(bags).click().build().perform();
        // Click on Product Name ‘Overnight Duffle’
        WebElement duffle = driver.findElement(xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[2]/div[1]/div[1]/strong[1]/a[1]"));
        actions.moveToElement(duffle).click().build().perform();
        //  Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = driver.findElement(xpath("//span[contains(text(),'Overnight Duffle')]")).getText();
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(1000);
        //  Change Qty 3
        clearTextToElement(xpath("//input[@id='qty']"));
        sendTextToElement(xpath("//input[@id='qty']"), "3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(xpath("//button[@id='product-addtocart-button']"));
        // Verify the text You added Overnight Duffle to your shopping cart.’
        String expectedMessage = "You added Overnight Duffle to your shopping cart.";
        String actualMessage = driver.findElement(xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on ‘shopping cart’ Link into message
        clickOnElement(xpath("//a[contains(text(),'shopping cart')]"));
        // Verify the product name ‘Overnight Duffle’
        String expectedText1 = "Overnight Duffle";
        String actualText1 = driver.findElement(xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")).getText();
        Assert.assertEquals(expectedText1, actualText1);
        Thread.sleep(1000);
        //  Verify the Qty is ‘3’
        String expectedQty = "3";
        String actualQty = driver.findElement(By.xpath("//input[@id='cart-236376-qty']")).getText();
        Assert.assertEquals(expectedQty, actualQty);
         //Verify the product price ‘$135.00’
        String expectedPrice = "$135.00";
        String actualPrice = driver.findElement(xpath("//span[@data-bind='text: getValue()'][normalize-space()='$135.00']")).getText();
        Assert.assertEquals(expectedPrice, actualPrice);
        Thread.sleep(1000);
        // Change Qty to ‘5’
        clearTextToElement(xpath("//input[@id='cart-236360-qty']"));
        sendTextToElement(xpath("//input[@id='cart-236360-qty']"),"5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(xpath("//span[normalize-space()='Update Shopping Cart']"));
        // Verify the product price ‘$225.00’
        String expectedProductPrice = "$225";
        String actualProductPrice = driver.findElement(xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")).getText();
        Assert.assertEquals(expectedProductPrice, actualProductPrice);

    }


    @After
    public void tearDown() {     // tear means close the browser
        //  closeBrowser();
    }
}
