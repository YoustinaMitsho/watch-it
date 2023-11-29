
//package person_based_movies;
//import jdk.internal.module.ModuleInfoExtender;

import person_based_movies.di;
import person_based_movies.director;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class ReadFileByLineExample {
    public static void main(String[] arg) {
        ArrayList<di> arrydata = new ArrayList<di>();
        String path = "movie_persion.txt";
        try {
            // Create a FileReader object to read the file
            FileReader fileReader = new FileReader(path);
            // Wrap the FileReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] values = line.split(",");
                // Process each value
                //System.out.println(value + " ");
                arrydata.add(new di(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]));
            }
            for (di value2 : arrydata) {
                //System.out.println(value + " ");
                //arrydata.add(new di(Integer.parseInt(values[0]),values[1],values[2],values[3],values[4]));
                System.out.println(value2.Age + " \n" + value2.Gender + "\n " + value2.Nationality + "\n " + value2.F_name + "\n " + value2.L_name);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("file not found");
            // Handle any potential IO exceptions (e.g., file not found)
            e.printStackTrace();
        }
/////////////////////// write on file////////////////


        //try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
        // Write content to the file
        // writer.write("Hello this is a line of text.");
        // writer.newLine(); // Add a newline character to move to the next line
        // writer.write("This is another line of text.");

        // You can continue writing more lines as needed

        //System.out.println("Content written to the file successfully.");
        //} catch (IOException e) {
        // Handle any potential IO exceptions
        //  e.printStackTrace();
        //}
    }

}
