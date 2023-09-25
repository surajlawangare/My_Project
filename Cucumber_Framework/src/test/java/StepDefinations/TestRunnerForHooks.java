package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/HooksDemo/Hooks.feature", glue= "StepsForHooks")

public class TestRunnerForHooks {


}
