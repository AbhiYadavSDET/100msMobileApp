<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Bank Transfer Flow">
    <test verbose="2" preserve-order="true" name="BankTransferTest.java">
        <groups>
            <run>
                <include name="bankTransferFlow"/>
            </run>
        </groups>


        <classes>
            <class name="BankTransferFlow.BankTransferTest"/>
        </classes>
    </test>

</suite>