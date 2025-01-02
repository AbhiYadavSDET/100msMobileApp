100ms Mobile App Automation
Overview
This repository contains the automation code for testing the 100ms mobile app. The automation is built using Appium and Java to automate the app's UI and verify its functionality from start to meeting page. The project also includes the automation of a complete end-to-end (E2E) flow, ensuring that the app launches correctly and the video functionality works as expected.

Technologies Used
Appium: For automating the mobile app
Java: Programming language for writing automation scripts
TestNG: For structuring the tests and managing the execution
Maven: For dependency management and build automation

Project Setup
Prerequisites
Java 11+ should be installed on your machine.
Appium should be installed. You can install Appium via npm:
bash
Copy code
npm install -g appium
Android SDK must be installed and configured properly on your system.
Appium Desktop is recommended for debugging tests.
Setup Steps
Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/AbhiYadavSDET/100msMobileApp.git
cd 100msMobileApp
Install the dependencies via Maven:

bash
Copy code
mvn clean install
Ensure your Android device or emulator is running.

Set up the Appium server and ensure the correct Android device is connected.

Running Tests
Run the tests using Maven:

bash
Copy code
mvn test
Tests will be executed sequentially on the app, verifying functionalities such as login, joining a meeting, and video playback.

E2E Flow Automated
Launch the app
Enter Name and Join Meeting
Verify the meeting page
Check if the video is showing correctly

Folder Structure
src/main/java: Contains the page objects and helper classes.
src/test/java: Contains the test cases for automating various actions and verifying the UI.
resources: Contains the necessary files like configuration files, appium settings, etc.

Common Issues & Troubleshooting
Device not connected: Ensure that your Android device is connected and properly configured. Use adb devices to check the connection.
Appium server issues: If the Appium server is not starting, try restarting it and check logs for errors.
Permission Issues: Make sure all the necessary permissions are granted to the app on the device.
Conclusion
This repository provides a comprehensive solution for automating the 100ms mobile app's UI and functional flows. It ensures that key features like meeting join and video display are working as expected.

Feel free to raise any issues or suggestions via GitHub Issues.
