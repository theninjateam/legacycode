/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Manhique
 */
public class TestLogIn {
    
    @Test
    public void testSimple() throws Exception {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit NetBeans
        driver.get("http://localhost:8081/Paginas/login/login.zul");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.netbeans.org");

        // Check the title of the page
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                WebElement user = d.findElement(By.id("dXKQd"));
                WebElement pass = d.findElement(By.id("dXKQj"));
                WebElement submeter = d.findElement(By.id("dXKQo"));
                user.sendKeys("mjunior");
                pass.sendKeys("mjunior");
                submeter.click();
                return d.getCurrentUrl().equalsIgnoreCase("http://localhost:8081/BV/Paginas/admin/circ_submissoes.zul");
            }
        });

        //Close the browser
        driver.quit();
    }
    
}
