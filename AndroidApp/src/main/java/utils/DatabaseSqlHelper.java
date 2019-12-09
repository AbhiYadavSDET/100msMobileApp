package utils;


import applicationcontext.ApplicationContextProvider;
import common.LoggerService;
import customexception.TestParametersNotFound;
import dbutil.mysql.automationtest.front_end_automation.FrontEndTestManager;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class DatabaseSqlHelper {


    public FrontEndTestManager frontEndTestManager;


    final Logger logger = LoggerService.getLogger(DatabaseSqlHelper.class);


    public void initiateFrontEndTest() {
        frontEndTestManager = (FrontEndTestManager) ApplicationContextProvider.getApplicationContext().getBean("frontEndTestManager");
    }


    public List<FrontEndEntity> getFrontEndTestData(String methodName) throws TestParametersNotFound {
        List<FrontEndEntity> params = frontEndTestManager.fetchTestParams(methodName);
        return params;
    }


}


