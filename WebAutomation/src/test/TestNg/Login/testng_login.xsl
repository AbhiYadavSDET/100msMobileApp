<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Login Flow">
    <test verbose="2" preserve-order="true" name="LoginTest.java">
        <groups>
            <run>
                <include name="loginFlow"/>
            </run>
        </groups>


        <classes>
            <class name="LoginFlow.LoginTest"/>
        </classes>
    </test>
</suite>