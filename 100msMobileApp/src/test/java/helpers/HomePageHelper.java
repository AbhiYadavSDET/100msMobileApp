package helpers;

import pageObject.HomePage;

public class HomePageHelper {

    private HomePage homePage;

    public HomePageHelper(HomePage homePage) {
        this.homePage = homePage;
    }

    // Helper method to join the meeting
    public void joinMeeting(String name, String meetingUrl) {
        homePage.enterName(name);                // Enter name
        homePage.enterMeetingUrl(meetingUrl);    // Enter meeting URL
        homePage.clickJoinNow();                 // Click Join Now
        homePage.clickJoinNowOnHomePage();       // Click Join Now on home page if required
    }

    // Helper method to leave the meeting
    public void leaveMeeting() {
        homePage.endMeetingSession();  // Click the "End Call" button to leave
    }

    public boolean isAtHomePage(){
        return homePage.isAtHomePage();
    }


    public boolean isMeetingJoined(){
        return homePage.isMeetingJoined();
    }

}
