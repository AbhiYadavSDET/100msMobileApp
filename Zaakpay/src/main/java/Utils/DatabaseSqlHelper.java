package Utils;


import applicationcontext.ApplicationContextProvider;
import common.LoggerService;
import customexception.*;
import dbutil.mysql.automationtest.kyc.KYCTestManager;
import dbutil.mysql.automationtest.kyc.entity.KycEntity;
import dbutil.mysql.mobikwik.member.MemberMerchantManager;
import dbutil.mysql.mobikwik.memberbalance.MemberbalanceMerchantManager;
import dbutil.mysql.mobikwik.merchantInfo.MerchantInfoManager;
import dbutil.mysql.mobikwik.mobi_koin_balanceMerchant.Mobi_koin_balanceMerchantManager;
import dbutil.mysql.mobikwik.otpdata.OtpDataDaoManager;
import org.apache.logging.log4j.Logger;
import Utils.TableEnums.MemberBalanceEnum;

import java.util.List;


public class DatabaseSqlHelper {

    public MemberbalanceMerchantManager memberbalanceMerchantManager;
    public Mobi_koin_balanceMerchantManager mobi_koin_balanceMerchantManager;
    public OtpDataDaoManager otpDataDaoManager;
    public MemberMerchantManager memberMerchantManager;

    public MerchantInfoManager merchantInfoManager;
    public KYCTestManager kycTestManager;

    final Logger logger = LoggerService.getLogger(DatabaseSqlHelper.class);


    public void initiateKycTest() {
        kycTestManager = (KYCTestManager) ApplicationContextProvider.getApplicationContext().getBean("KYCTestManager");
    }

    public List<KycEntity> getKycTestData(String methodName) throws TestParametersNotFound {
        List<KycEntity> params = kycTestManager.fetchTestParams(methodName);
        return params;
    }

    public void initiateMemberBalance() {
        memberbalanceMerchantManager = (MemberbalanceMerchantManager) ApplicationContextProvider.getApplicationContext().getBean("memberbalanceMerchantManager");
    }


    public void initiateMobicoin() {
        mobi_koin_balanceMerchantManager = (Mobi_koin_balanceMerchantManager) ApplicationContextProvider.getApplicationContext().getBean("mobi_koin_balanceMerchantManager");
    }

    public void initiateMember() {
        memberMerchantManager = (MemberMerchantManager) ApplicationContextProvider.getApplicationContext().getBean("memberMerchantManager");
    }

    public void updatesupercashbalance(String member_id, String point) {
        try {
            logger.info("Before txn supercash is :" + mobi_koin_balanceMerchantManager.getSupercash(member_id));
            mobi_koin_balanceMerchantManager.updateSupercash(member_id, Double.parseDouble(point));
            logger.info("Before txn supercash is :" + mobi_koin_balanceMerchantManager.getSupercash(member_id));
        } catch (MemberNotFoundInmobi_koin_balance memberNotFoundInmobiKoinBalance) {
            memberNotFoundInmobiKoinBalance.printStackTrace();
        }
    }

    public void updateWalletMainBalance(String memberId, String amount) {
        try {
            Config.logComment("Wallet before balance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getBalance());
            memberbalanceMerchantManager.updateWalletBalance(memberId, amount);
            Config.logComment("Wallet balance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getBalance());
        } catch (MemberNotFoundInMemberBalance memberNotFoundInMemberBalance) {
            memberNotFoundInMemberBalance.printStackTrace();
        }
    }


    public void updateWalletOtherBalance(String memberId, double amount) {
        try {
            logger.info("Wallet before otherBalance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getOtherBalance());
            memberbalanceMerchantManager.updateWalletOtherBalance(memberId, amount);
            logger.info("Wallet otherBalance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getOtherBalance());
        } catch (MemberNotFoundInMemberBalance memberNotFoundInMemberBalance) {
            memberNotFoundInMemberBalance.printStackTrace();
        }
    }

    public double getWalletOtherBalance(String memberId) {
        double otherBalance = 0;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            otherBalance = memberbalanceMerchantManager.getMemberDetails(memberId).getOtherBalance();
        } catch (MemberNotFoundInMemberBalance memberNotFoundInMemberBalance) {
            memberNotFoundInMemberBalance.printStackTrace();
        }
        logger.info("Wallet other balance is : " + otherBalance);
        return otherBalance;
    }

    public double getWalletMainBalance(String memberId) {
        String balance = "";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            balance = memberbalanceMerchantManager.getMemberDetails(memberId).getBalance();
        } catch (MemberNotFoundInMemberBalance memberNotFoundInMemberBalance) {
            memberNotFoundInMemberBalance.printStackTrace();
        }
        return Double.parseDouble(balance);
    }

    public void updateWalletBucket6Balance(String memberId, double amount) {
        try {
            logger.info("Wallet before bucket6 balance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getBucket6());
            memberbalanceMerchantManager.updateWalletBucket6Balance(memberId, amount);
            logger.info("Wallet bucket6 balance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getBucket6());
        } catch (MemberNotFoundInMemberBalance memberNotFoundInMemberBalance) {
            memberNotFoundInMemberBalance.printStackTrace();
        }
    }

    public void updateWalletBucket1Balance(String memberId, double amount) {
        try {
            logger.info("Wallet before bucket1 balance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getBucket1());
            memberbalanceMerchantManager.updateWalletBucket1Balance(memberId, amount);
            logger.info("Wallet bucket6 balance is : " + memberbalanceMerchantManager.getMemberDetails(memberId).getBucket1());
        } catch (MemberNotFoundInMemberBalance memberNotFoundInMemberBalance) {
            memberNotFoundInMemberBalance.printStackTrace();
        }
    }

    public double getMobikoin(String memberid) {
        double point = 0;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            point = mobi_koin_balanceMerchantManager.getSupercash(memberid);
        } catch (MemberNotFoundInmobi_koin_balance memberNotFoundInmobiKoinBalance) {
            memberNotFoundInmobiKoinBalance.printStackTrace();
        }

        return point;
    }

    public double getMemeberBalance(String memberId, MemberBalanceEnum memberbalanceEnum) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            switch (memberbalanceEnum) {
                case BAL:
                    return Double.parseDouble(memberbalanceMerchantManager.getMemberDetails(memberId).getBalance());
                case OTHBAL:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getOtherBalance();
                case LYBAL:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getLoyalityBalance();
                case PHONE:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getPhone();
                case FUEL:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getFuel();
                case MEDICAL:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getMedical();
                case NONINS:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getNonInsurance();
                case BUC1:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getBucket1();
                case BUC2:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getBucket2();
                case BUC3:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getBucket3();
                case BUC4:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getBucket4();
                case BUC5:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getBucket5();
                case BUC6:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getBucket6();
                case BUC7:
                    return memberbalanceMerchantManager.getMemberDetails(memberId).getBucket7();
                default:
                    System.out.println("Column name not found");
                    return -1;
            }
        } catch (MemberNotFoundInMemberBalance memberNotFoundInMemberBalance) {
            memberNotFoundInMemberBalance.printStackTrace();
            return -1;

        }
    }


    public void initiateOtpData() {
        otpDataDaoManager = (OtpDataDaoManager) ApplicationContextProvider.getApplicationContext().getBean("otpDataDaoManager");
    }


    public String getOtp(String cellNumber) {
        String otp = "";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            otp = otpDataDaoManager.get(cellNumber).getOtp();
            logger.info("Otp for " + cellNumber + " is " + otp);
        } catch (CellNotFoundInOTPTable cellNotFoundInOTPTable) {
            cellNotFoundInOTPTable.printStackTrace();
        }
        return otp;
    }


//    public double getMemberBalanceWithCategory(String mid, String memberId) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String category = getMerchantCaregory(mid);
//        logger.info("Merchant category is : " + category);
//        double memberBalance = 0.0;
//        if (category.equalsIgnoreCase("FOOD")) {
//            memberBalance = getMemeberBalance(memberId, MemberbalanceEnum.BAL) + getMemeberBalance(memberId, MemberbalanceEnum.BUC6) + getMemeberBalance(memberId, MemberbalanceEnum.OTHBAL);
//            memberBalance = NumberFormatter.roundDouble(memberBalance, RoundingMode.HALF_DOWN);
//            logger.info(memberId + " balance is " + memberBalance);
//        }
//        if (category.equalsIgnoreCase("NULL")) {
//            memberBalance = getMemeberBalance(memberId, MemberbalanceEnum.BAL) + getMemeberBalance(memberId, MemberbalanceEnum.BUC6);
//            memberBalance = NumberFormatter.roundDouble(memberBalance, RoundingMode.HALF_DOWN);
//            logger.info(memberId + " balance is " + memberBalance);
//        }
//        return memberBalance;
//    }


    public String getMemberKycStatus(String memberId) {
        String status = "";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            status = memberMerchantManager.getKycStatus(memberId);
        } catch (MemberNotFoundInMemberTable memberNotFoundInMemberTable) {
            memberNotFoundInMemberTable.printStackTrace();
        }
        return status;
    }

    public void updateMemberKycStatus(String memberId, String kycStatus) {
        try {
            Config.logComment("Member Kyc Status before : " + memberMerchantManager.getKycStatus(memberId));
            memberMerchantManager.updateKycStatus(memberId, kycStatus);
            Config.logComment("Member Kyc Status after : " + memberMerchantManager.getKycStatus(memberId));
        } catch (MemberNotFoundInMemberTable memberNotFoundInMemberTable) {
            memberNotFoundInMemberTable.printStackTrace();
        }
    }
}


