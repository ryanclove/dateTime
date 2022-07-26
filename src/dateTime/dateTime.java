package dateTime;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class dateTime {

	// Main driver method
    public static void main(String[] args)
    {
        // Try block to check for exceptions
        try {
 
            // Creating a FileReader object 
            FileReader fr = new FileReader("testFile.txt");
 
            // Creating a FileWriter object
            FileWriter fw = new FileWriter("validDateTimes.txt");
 
            // Declaring a blank string in which content of file will be stored
            String str = "";
 
            int i;
 
            // read() method will read the file char by char
            // EOF = -1
            while ((i = fr.read()) != -1) {
                // Storing every character in the string
                str += (char)i;
            }
 
            // Print and display the string that contains file data
            System.out.println(str);
 
            // Write string to write object
            fw.write(str);
 
            // close streams
            fr.close();
            fw.close();
 
            // Display message
            System.out.println(
                "File reading and writing both successful");
        }
 
        // Catch block to handle the exception like no file in path
        catch (IOException e) {
            // Display message
            System.out.println("There are some IOException" + e);
        }
    }
}
