package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static StepDefinitions.Common.Hooks.driver;

/**
 * Created by rneves on 1/21/16.
 */
public class SearchPage {
    protected static final String  RESULTS_LIST = "results-list";
    protected static final String  CONTENT_TYPE_FILTER = "content-type-facet";
    protected static final String  DISCIPLINE_FILTER = "discipline-facet";
    protected static final String  SUB_DISCIPLINE_FILTER = "sub-discipline-facet";
    protected static final String  LANGUAGE_FILTER = "language-facet";



    public static void findElement(String element) throws Exception{
        // This function asserts the presence of mandatory elements when a result list is expected
        switch (element.toLowerCase()) {
            case "results list":
                findByID(RESULTS_LIST);
                break;
            case "filters box":
                findByID(CONTENT_TYPE_FILTER);
                findByID(DISCIPLINE_FILTER);
                findByID(SUB_DISCIPLINE_FILTER);
                findByID(LANGUAGE_FILTER);
                break;
            case "details header":
                driver.findElement(By.className("number-of-search-results-and-search-terms"));
                break;
            default:
                throw new Exception("Not on proper Window! No URL Match");
        }
    }

    private static void findByID(String accessor) throws Exception{
        // This function identifies by ID the elements required. On a larger project, this shouldn't be here!
        driver.findElement(By.id(accessor));
    }

    public static void amountCheck(boolean noResults) throws Exception{
        // This function solely checks for diferences on what is expected and reality
        String textresult = amountAssessment();
        if( noResults != textresult.equals("0")) {
            if (noResults) {
                throw new Exception("Some results have appeared. There should be 0 results.");
            }
            else {
                throw new Exception("No results where found. There should be some.");
            }
        }
    }

    public static String amountAssessment() {
        // This function assesses the content of the HTML element that provides the amount
        WebElement header = driver
                .findElement(By.className("number-of-search-results-and-search-terms"))
                .findElement(By.tagName("strong"));
        return header.getAttribute("innerHTML");
    }
}


