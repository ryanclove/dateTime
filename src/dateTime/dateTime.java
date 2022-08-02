package dateTime;

import java.io.*;
import java.util.*;

public class dateTime {

	// Checks for Valid Time
	public static boolean validator(String str) {
		// Check if enough chars in str
		if ((str.length() != 20) && (str.length() != 25)) {
			// Incorrect amount of characters to be a proper ISO 6801
			return false;
		}
		String year = str.substring(0, 4);
		String month = str.substring(5, 7);
		String day = str.substring(8, 10);
		String time = str.substring(10, 11);
		String hour = str.substring(11, 13);
		String min = str.substring(14, 16);
		String sec = str.substring(17, 19);
		String zone = str.substring(19, 20);
		// Check conditions per substring/parameter
		if (isYear(year) && isMonth(month) && isDay(day) && (time.indexOf("T") == 0) && isHour(hour) && isMinOrSec(min)
				&& isMinOrSec(sec)
				&& ((zone.indexOf("Z") == 0) || (zone.indexOf("+") == 0) || (zone.indexOf("-") == 0))) {
			// if time has time zone other than Z, check hh:mm == +-hh:mm
			if (str.length() == 25) {
				String zonehr = str.substring(20, 22);
				String zonemin = str.substring(23, 25);
				if ((hour.equals(zonehr)) && (min.equals(zonemin))) {
					return true;
				} else { // hh:mm's are not equal
					return false;
				}
			} else { // 20 chars
				
				return true;
			}
		} else {
			return false;
		}
	}

	// Helper method to check for numeric in strings - year
	public static boolean isYear(String string) {
		if (string == null || string.equals("")) {
			// String cannot be parsed, it is null or empty
			return false;
		}
		try {
			int intValue = Integer.parseInt(string);
			if (string.length() == 4) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			// Input String cannot be parsed to Integer
		}
		return false;
	}

	// Helper method for month
	public static boolean isMonth(String string) {
		if (string == null || string.equals("")) {
			// String cannot be parsed, it is null or empty
			return false;
		}
		try {
			int intValue = Integer.parseInt(string);
			if (intValue >= 01 && intValue <= 12) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			// Input String cannot be parsed to Integer
		}
		return false;
	}

	// Helper method for day
	public static boolean isDay(String string) {
		if (string == null || string.equals("")) {
			// String cannot be parsed, it is null or empty
			return false;
		}
		try {
			int intValue = Integer.parseInt(string);
			if (intValue >= 01 && intValue <= 31) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			// Input String cannot be parsed to Integer
		}
		return false;
	}

	// Helper method for hour
	public static boolean isHour(String string) {
		if (string == null || string.equals("")) {
			// String cannot be parsed, it is null or empty
			return false;
		}
		try {
			int intValue = Integer.parseInt(string);
			if (intValue >= 00 && intValue <= 23) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			// Input String cannot be parsed to Integer
		}
		return false;
	}

	// Helper method for minute and seconds
	public static boolean isMinOrSec(String string) {
		if (string == null || string.equals("")) {
			// String cannot be parsed, it is null or empty
			return false;
		}
		try {
			int intValue = Integer.parseInt(string);
			if (intValue >= 00 && intValue <= 59) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			// Input String cannot be parsed to Integer
		}
		return false;
	}

	// Main driver method
	public static void main(String[] args) {
		// Try block to check for exceptions
		try {

			// Creating a FileReader object
			FileReader fr = new FileReader("testFile2.txt");

			// Creating a FileWriter object
			FileWriter fw = new FileWriter("validDateTimes.txt");

			// Declaring a set because it won't store duplicates
			Set<String> set = new HashSet<>();

			// Read file contents line by line
			try (BufferedReader br = new BufferedReader(fr)) {
				String line;
				while ((line = br.readLine()) != null) {
					// process the line, add it to set.
					set.add(line);
				}
			}

			// Declaring an arrayList to store the Strings from the Set
			ArrayList<String> list = new ArrayList<String>(set);

			// Write
			try {
				// Declaring a blank string in which content of file will be stored
				for (String str : list) {
					// Call helper method for checking valid times
					if (validator(str) == true) {
						// write to file
						fw.write(str + System.lineSeparator());
						// Print and display the string that contains file data to console
						// System.out.println(str);
					}
				}

				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

			// close streams
			fr.close();
			fw.close();

			// Display message
			System.out.println("Successfully executed");
		}

		// Catch block to handle the exception like no file in path
		catch (IOException e) {
			// Display message
			System.out.println(e);
		}
	}
}
