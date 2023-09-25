package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/BackGround/BackGroundDemo.feature", glue="StepsForBackGround")

public class TestRunnerForBackGround {


}
