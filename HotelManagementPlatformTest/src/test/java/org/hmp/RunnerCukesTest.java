package org.hmp;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by inet-tech on 14/02/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber_reports"}
        ,features = {"src/test/resources"}
        ,snippets = SnippetType.CAMELCASE
        //,tags = {"@Ignore"}
        )

public class RunnerCukesTest {
}
