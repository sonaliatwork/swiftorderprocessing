package org.swift.order;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class UserLoginHelper {

	private static final UserLoginHelper userOperator = new UserLoginHelper();
	private static final String userLoginFileName = "USERDLOGINDETAILS";
	private static final int FIELD_COUNT_USER_DETAILS = 2;
	private static BufferedReader br = null;

	public static UserLoginHelper getInstance() {
		return userOperator;
	}

	public void validateUser() {
		
		boolean validUserFound = false;
		int loginAttemptCount = 0;
		while (!validUserFound && loginAttemptCount < 3) {

			validUserFound = docheckUserAuthorization();
			loginAttemptCount++;
		}
		if (loginAttemptCount >= 3) {
			System.out.println("\nYou have exhausted all the login attempts, exiting from the system, Thank you!");
			System.exit(0);
		}
	}

	public boolean docheckUserAuthorization() {

		String username = "";
		String passwordString = "";
		char[] passwordChars = null;
		boolean userFoundStatus = false;
		Console console = System.console();

		try {

			console.printf("\nPlease enter your username: ");
			username = console.readLine();

			console.printf("Please enter your password: ");
			passwordChars = console.readPassword();
			passwordString = new String(passwordChars);

			userFoundStatus = doUserAuthorization(username, passwordString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (userFoundStatus)
			console.printf("User is Authorized to use the System! \n********************\n");
		else
			console.printf("UserName/Password did not match! \n\n");
		return userFoundStatus;
	}

	protected static String getFileLocation() {
		String fileLocation = "";
		try {
			fileLocation = PropertiesConfiguration.getInstance().getPropertiesConfiguration(userLoginFileName);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return fileLocation;
	}

	private static boolean doUserAuthorization(String username, String password) throws IOException {
		String fileLocation = getFileLocation();
		return userAuthOperation(username, password, fileLocation);

	}

	public File getFileContent(String fileLocation) {
		
		File file = new File(getClass().getClassLoader().getResource(fileLocation).getFile());
		return file;
	}

	private static boolean userAuthOperation(String userName, String password, String fileLocation) {

		String singleRecordFromFile = "";
		boolean userfound = false;

		String fields[] = new String[FIELD_COUNT_USER_DETAILS];

		try {
			File file = UserLoginHelper.getInstance().getFileContent(fileLocation);

			if (file == null || !file.exists()) {
				System.out.println("Sorry, User auth facing issue!");
				return false;
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((singleRecordFromFile = br.readLine()) != null) {

				fields = singleRecordFromFile.split(" ");
				if (!(fields == null || fields.length < FIELD_COUNT_USER_DETAILS)) {

					if (fields[0].contains(userName)) {
						if (fields[1] != null && fields[1].contains(password)) {
							userfound = true;
							return userfound;
						}

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userfound;
	}

}
