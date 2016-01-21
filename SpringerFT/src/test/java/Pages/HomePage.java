package Pages;


import org.openqa.selenium.By;

import static Common.Navigator.isOnPage;
import static StepDefinitions.Common.Hooks.driver;

/**
 * Created by rneves on 1/21/16.
 */
public class HomePage {
    public static void gotoHome() throws Exception{
        // THis function directs the browser to the target and checks if we are on the proper page
        String url ="http://link.springer.com";
        driver.get(url);
        isOnPage("Home");
    }

    public static void query_searcher(String query) {
        // this function inputs the query on the search box
        driver.findElement(By.id("query")).sendKeys(query);
    }


    public static void press_search() {
        // This function just presses the button...
        driver.findElement(By.id("search")).click();
    }
}
