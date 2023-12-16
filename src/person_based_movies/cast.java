package person_based_movies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class cast extends movie_person {

   public static ArrayList<cast> cast_list = new ArrayList<cast>();

    {
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
                cast_list.add(new cast(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]));
                //System.out.println(value + " ");
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("file not found");
            // Handle any potential IO exceptions (e.g., file not found)
            e.printStackTrace();
        }
    }

    cast(int age, String Gender, String nationality, String f_name, String l_name) {
        super(age, Gender, nationality, f_name, l_name);

    }


}
