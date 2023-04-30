package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="C:\\Users\\003IBZ744\\IdeaProjects\\untitled2\\src\\test\\java\\Feature\\Activity3.feature",
glue = {"Step_definition"},
//plugin = {"html: test-reports.html"},
        //plugin = {"pretty"},
        plugin = {"json: test-reports.json"},
        monochrome = true,
tags = "@SmokeTesting"
  //tags = "not @PromptAlert"
        //tags = "@PromptAlert"
        //tags = "@activity3"
        //tags = "@activity5"

)
public class TestRunner {
}
