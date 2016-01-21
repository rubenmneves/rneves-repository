package Common;

import static StepDefinitions.Common.Hooks.driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by rneves on 1/21/16.
 */
public class Navigator {
    static public void isOnPage(String page)throws Exception {
        String url = selector(page);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait
                .withTimeout(10, TimeUnit.SECONDS)
                .withMessage("\n\n=====   ERROR   =====\n\nNot on proper Window! Wrong URL match - " + page + "\n\n=====   ERROR   =====\n\n")
                .pollingEvery(333, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.urlMatches("\\S*"+url+"\\S*"));
    }

    static private String selector(String page) throws Exception {
        String url = "";
        switch (page.toLowerCase()) {
            case "home":
                url = "link.springer.com";
                break;
            case "search results":
                url = "springer.com/search?";
                break;
            default:
                throw new Exception("Not on proper Window! No URL Match");
        }
        return url;
    }
}
