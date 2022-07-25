package dateTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dateTime {

	static void readFile() throws FileNotFoundException {
		File file = new File("C:\\Users\\ryanc\\eclipse-workspace\\dateTime\\testFile.txt");
		Scanner sc = new Scanner(file);
		try {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} finally {
			sc.close();
		}
	}

	static void createFile() {
		try {
			File output = new File("validDateTimes.txt");
			if (output.createNewFile()) {
				System.out.println("File created: " + output.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	static void writeFile() {
		try {
			FileWriter myWriter = new FileWriter("validDateTimes.txt");
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		readFile();
		createFile();
		writeFile();
	}
}
