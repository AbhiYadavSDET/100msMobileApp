package tests;

import helpers.HomePageHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;

import java.net.MalformedURLException;

public class AppTest extends BaseTest {

    private HomePageHelper homePageHelper;

    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        homePageHelper = new HomePageHelper(new HomePage(driver));
    }

    @Test
    public void testJoinAndLeaveMeeting() {

        // Step 1: Join the meeting
        homePageHelper.joinMeeting("Abhishek yadav", "https://abhishek-audioroom-1937.app.100ms.live/meeting/xii-rjuz-vfm");

        Assert.assertTrue(homePageHelper.isMeetingJoined(), "user is not able to join meeting");

// Step 2: Leave the meeting after joining
        homePageHelper.leaveMeeting();

        Assert.assertTrue(homePageHelper.isAtHomePage(), "User is not present at home page");

    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
    }
}
