package dateTime;

import java.io.*;
import java.util.*;

public class dateTime {

	static class validTime {
		// ISO 8601 YYYY-MM-DDThh:mm:ssTZD
		private String year;
		private String month;
		private String day;
		private String time;
		private String hour;
		private String min;
		private String sec;
		private String zone;

		public validTime(String year, String month, String day, String time, String hour, String min, String sec,
				String zone) {
			// System.out.println(setYear(year));
			setYear(year);
			// System.out.println(setMonth(month));
			setMonth(month);
			// System.out.println(setDay(day));
			setDay(day);
			// System.out.println(setTime(time));
			setTime(time);
			// System.out.println(setHour(hour));
			setHour(hour);
			// System.out.println(setMin(min));
			setMin(min);
			// System.out.println(setSec(sec));
			setSec(sec);
			// System.out.println(setZone(zone));
			setZone(zone);
			return;
		}

		public String getYear() {
			return year;
		}

		public boolean setYear(String year) {
			if (isNumeric(year)) {
				this.year = year;
				return true;
			} else {
				return false;
			}
		}

		public String getMonth() {
			return month;
		}

		public boolean setMonth(String month) {
			if (isNumeric(month)) {
				this.month = month;
				return true;
			} else {
				return false;
			}
		}

		public String getDay() {
			return day;
		}

		public boolean setDay(String day) {
			if (isNumeric(day)) {
				this.day = day;
				return true;
			} else {
				return false;
			}
		}

		public String getTime() {
			return time;
		}

		public boolean setTime(String time) {
			if (time.indexOf("T") == 0) {
				this.time = time;
				return true;
			} else {
				return false;
			}
		}

		public String getHour() {
			return hour;
		}

		public boolean setHour(String hour) {
			if (isNumeric(hour)) {
				this.hour = hour;
				return true;
			} else {
				return false;
			}
		}

		public String getMin() {
			return min;
		}

		public boolean setMin(String min) {
			if (isNumeric(min)) {
				this.min = min;
				return true;
			} else {
				return false;
			}
		}

		public String getSec() {
			return sec;
		}

		public boolean setSec(String sec) {
			if (isNumeric(sec)) {
				this.sec = sec;
				return true;
			} else {
				return false;
			}
		}

		public String getZone() {
			return zone;
		}

		public boolean setZone(String zone) {
			if (zone.indexOf("Z") == 0) {
				this.zone = zone;
				return true;
			} else if ((zone.indexOf("+") == 0)) {
				this.zone = zone;
				return true;
			} else if ((zone.indexOf("-") == 0)) {
				this.zone = zone;
				return true;
			} else { // incorrect zone
				return false;
			}
		}
	}

	// Checks for Valid Time
	public static boolean validator(String str) {
		// Check if enough chars in str
		if ((str.length() != 20) && (str.length() != 25)) {
			// System.out.println("Incorrect amount of characters to be a proper ISO 6801");
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
		validTime timecheck = new validTime(year, month, day, time, hour, min, sec, zone);
		// if (timecheck == true) {
		return true;
		// } else {
		// return false;
		// }
	}

	// Helper method to check for numeric in strings
	public static boolean isNumeric(String string) {
		if (string == null || string.equals("")) {
			// System.out.println("String cannot be parsed, it is null or empty.");
			return false;
		}
		try {
			int intValue = Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			// System.out.println("Input String cannot be parsed to Integer.");
		}
		return false;
	}

	// Main driver method
	public static void main(String[] args) {
		// Try block to check for exceptions
		try {

			// Creating a FileReader object
			FileReader fr = new FileReader("testFile.txt");

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
						// Print and display the string that contains file data
						System.out.println(str);
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
