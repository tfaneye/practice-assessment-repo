package org.hmp.support;

import org.hmp.browsers.SharedBrowsers;
import org.hmp.page_objects.BasePage;
import org.hmp.page_objects.DataEntryPage;
import org.hmp.page_objects.HomePage;

/**
 * Created by inet-tech on 14/02/17.
 */
public class WorldHelper extends SharedBrowsers {


    private BasePage basePage;
    private DataEntryPage dataEntryPage;

    public BasePage getBasePage(){
        if(basePage == null){
            basePage = new BasePage(driver);
        }
        return basePage;
    }

    public DataEntryPage getDataEntryPage(){
        if(dataEntryPage == null){
            dataEntryPage = new DataEntryPage(driver);
        }
        return dataEntryPage;
    }


}
