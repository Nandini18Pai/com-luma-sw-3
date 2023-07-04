package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {

        //Mouse Hover on Men Menu
        WebElement menMenu = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
        Actions menu = new Actions(driver);
        menu.moveToElement(menMenu).build().perform();

        // Mouse Hover on Bottoms

        WebElement menBottoms = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));
        Actions menBottoms1 = new Actions(driver);
        menBottoms1.moveToElement(menBottoms).build().perform();

        // Click on Pants

        WebElement menPants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        Actions pants = new Actions(driver);
        pants.moveToElement(menPants).click().build().perform();


        // Mouse Hover on product name  //‘Cronus Yoga Pant’ and click on size 32.

        WebElement yogaPants = driver.findElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        WebElement size = driver.findElement(By.xpath( "//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        WebElement colour = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]"));
        WebElement cart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        Actions pants1 = new Actions(driver);
        pants1.moveToElement(yogaPants).build().perform();
        pants1.moveToElement(size).click().build().perform();
        pants1.moveToElement(colour).click().build().perform();// Mouse Hover on product name Cronus Yoga Pant’ and click on colourBlack.
        pants1.moveToElement(cart).click().build().perform();// Mouse Hover on product name ‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.


        // Verify the text You added Cronus Yoga Pant to your shopping cart.’
            String expectedMessage="You added Cronus Yoga Pant to your shopping cart.";
            String actualMessage = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
            Assert.assertEquals(expectedMessage,actualMessage);

        // Click on ‘shopping cart’ Link into message
            clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        // Verify the text ‘Shopping Cart.’
        String expectedMessage1="Shopping Cart";
        String actualMessage1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedMessage1,actualMessage1);

        // Verify the product name ‘Cronus Yoga Pant’
        String expectedMessage2= "Cronus Yoga Pant";
        String actualMessage2 = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        Assert.assertEquals(expectedMessage2,actualMessage2);

        // Verify the product size ‘32’
        String expectedMessage3= "32";
        String actualMessage3 = driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
        Assert.assertEquals(expectedMessage3,actualMessage3);


        // Verify the product colour ‘Black
        String expectedMessage4= "Black";
        String actualMessage4 = driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
        Assert.assertEquals(expectedMessage4,actualMessage4);

    }


    @After
    public void tearDown() {     // tear means close the browser
        //  closeBrowser();
    }
}
