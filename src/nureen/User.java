package nureen;

import mitsho.Movie;

import java.util.*;
public class User extends personx{
    int age; //3shan offer films related
    String nationality;//3shan offer films related
    String subscription_type;

    String []wartchlater = new String [200];
    String []alreadywatched  = new String [200]; // is a class to be implemented later, will have child here
    public void chooseplan(String plantype,int basic_counter,int standard_counter, int premium_counter){
        System.out.println("choose your plan");
        Scanner input =new Scanner(System.in);
        if (plantype.equals("basic")){
            basic_counter++;
        }
        else if (plantype.equals("standard")) {
            standard_counter++;

        } else if (plantype.equals("premium")) {
            premium_counter++;

        }

    }


}
