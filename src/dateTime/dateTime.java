package dateTime;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class dateTime {

	public boolean validDateFormat(String str) {
		// ISO 8601 YYYY-MM-DDThh:mm:ssTZD
		SimpleDateFormat iso = new SimpleDateFormat("YYYY-MM-DDThh:mm:ssTZD");

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

			try (BufferedReader br = new BufferedReader(fr)) {
				String line;
				while ((line = br.readLine()) != null) {
					// process the line, add it to ArrayList.
					set.add(line);
				}
			}

			// Declaring an arrayList to store the Strings from the Set
			ArrayList<String> list = new ArrayList<String>(set);

			// Write
			try {
				// Declaring a blank string str in which content of file will be stored
				for (String str : list) {
					// write to file
					fw.write(str + System.lineSeparator());
					// Print and display the string that contains file data
					System.out.println(str);
				}
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

			// close streams
			fr.close();
			fw.close();

			// Display message
			System.out.println("File reading and writing both successful");
		}

		// Catch block to handle the exception like no file in path
		catch (

		IOException e) {
			// Display message
			System.out.println(e);
		}
	}
}
