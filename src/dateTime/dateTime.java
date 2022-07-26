package dateTime;

import java.io.BufferedReader;
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
           
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                   // process the line.
                	str += line + "\n";
                }
            }
 
            // Print and display the string that contains file data
            System.out.println(str);
 
            // Write string to write object
            fw.write(str);
 
            // close streams
            fr.close();
            fw.close();
 
            // Display message
            System.out.println("File reading and writing both successful");
        }
 
        // Catch block to handle the exception like no file in path
        catch (IOException e) {
            // Display message
            System.out.println(e);
        }
    }
}
