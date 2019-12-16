package utils;

import common.LoggerService;
import customexception.PolicyNotFoundInPolicyCollection;
import dbutil.mongo.policy.PolicyManager;
import logger.Log;
import org.apache.logging.log4j.Logger;

public class DatabaseMongoHelper {

    public PolicyManager policyManager;

    static final Logger logger = LoggerService.getLogger(DatabaseMongoHelper.class);
    //Mongo collection instances

    public void initiatePolicy() {
        //policyManager = (PolicyManager) ApplicationContextProvider.getApplicationContext().getBean("policyManager");
    }

    public void deletePolicies(String memberId) throws PolicyNotFoundInPolicyCollection {
        try {
            Log.info("No of policies : " + policyManager.getPolicyDetails(memberId).size());
            policyManager.deletePolicies(memberId);
            Log.info("No of policies : " + policyManager.getPolicyDetails(memberId).size());
        } catch (PolicyNotFoundInPolicyCollection e) {
            Log.info("No of policies : 0");
        }
    }


}
