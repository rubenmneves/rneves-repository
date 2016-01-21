package search.springer;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by rneves on 1/21/16.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(
        features = {"src/test/features"}
)
public class CucumberRunner {
}
