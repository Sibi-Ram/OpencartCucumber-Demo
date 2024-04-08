package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					//features= {"./Features/"},//will execute all feature files in features folder
					//features= {"./Features/Login.feature"},//execute specific feature file
					features= {"./Features/LoginDDTExcel.feature"},
				//	features= {"./Features/Login.feature","./Features/Registration.feature"},//for selecting multiple feature files
					//features= {"@target/rerun.txt"},//re running failure scenarios
					glue="stepDefinitions",//package name of step definition
//we can't specify particular step definition file since all step definition file depends on HOOKS
					plugin= {"pretty", "html:reports/myreport.html", //J unit cucumber default report; mention reports/folder; Local system- storage
							  "rerun:target/rerun.txt",//capture the test failures
//rerun.txt will contain the entries which were failed in previous runs
//in target/ it will create rerun.txt....Next time we can run only the failed stuff.
//next round of execution we have to enable //features= {"@target/rerun.txt"} and comment the feature file which was executed 1st time
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"//extent report - we don't need to create separate listener class for cucumber ...
	//  just enable this would be enough // also add extent.properties in resources folder and configure folder path and name and also the default documentation lines 
//plugin will be useful for generating reports
							},


//when dry run= true - when we run feature file it will only check every step in (FEature file)scenario is having associated method or not.
//but won't execute in application .... it will just check association when it is false it will check association between 2 and also execute the program
					dryRun=false,    // checks mapping between Feature file scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters (like *, ? ...)in output in jenkins we can see those junk characters
					publish=true   // to publish CUCUMBER report in cucumber server
					
//Grouping .... In TestNG we execute grouping by xml include xml groups like that
					
//For J unit grouping... To execute specific scenarios of feature files add Tags in feature files
					//tags="@sanity"  // this will execute scenarios from all feature files tagged with @sanity
					//tag names are userdefined...
					//tags="@regression"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression//and - Keyword
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner {

}
