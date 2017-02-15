package org.hmp.hooks;

import cucumber.api.java.Before;
import org.hmp.browsers.SharedBrowsers;
import org.hmp.page_objects.BasePage;
import org.junit.After;

/**
 * Created by inet-tech on 14/02/17.
 */
public class StepHooks {

    private SharedBrowsers sharedBrowsers;
    protected BasePage basePage;

    public StepHooks(SharedBrowsers sharedBrowsers) {
        this.sharedBrowsers = sharedBrowsers;
    }

    @Before
    public void setUpTest() throws Exception {
        basePage = sharedBrowsers
                .initialiseBrowser()
                .setUpBrowser();
    }

    @After
    public void tearDownTest(){
        sharedBrowsers
                .tearDownBrowser();
    }
}
