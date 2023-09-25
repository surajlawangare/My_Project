package Tags;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeatureTag", glue= {"StepDefinations"}, tags= "@smoke")

public class TagDemo {

}
