import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public abstract class movie_person {
    public int Age ;
    public String Gender;
    public String Nationality;
    public String F_name;
    public String L_name;

    movie_person(int age,String Gender,String nationality,String f_name,String l_name){
        this.Age=age;
        this.Gender=Gender;
        this.Nationality=nationality;
        this.L_name=l_name;
        this.F_name=f_name;

    }

}
