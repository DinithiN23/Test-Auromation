package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepsDefinition","utils"},
   plugin = {"pretty", 
		   "html:target/cucumber-reports/report.html",
		   "json:target/cucumber-reports/cucumber.json",
	        "junit:target/cucumber-reports/cucumber.xml",
	        "rerun:target/cucumber-reports/rerun.txt"
	        },
    monochrome = true,
    publish = false
)
public class Runner {
	 
}

