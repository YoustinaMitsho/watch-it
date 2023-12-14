package NONOOOO;
import mitsho.*;
import nureen.*;
//import mitsho.Movie;
import nureen.User;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

    public class Main {
        public static void main(String args[]){
            //welcome();
            DisplayUserDiscoverPg();
            //UserProfile();
        }

        public static void  register()
        {
            Scanner inputuser= new Scanner(System.in);
            ArrayList users = new ArrayList();
            int choice_login;
            System.out.println("\"enter 1 for user /n\"+ \"enter 2 for admin\" ");

            choice_login=inputuser.nextInt();
            if (choice_login == 1)
            {
                System.out.println(" WELCOME  USER TO WATCHIT");
                System.out.println("enter your email:");
                String email= inputuser.next();//email
                System.out.println("enter your username:");
                String username= inputuser.next();//username
                System.out.println("enter your password:");
                String password= inputuser.next();//password
                System.out.println("enter your first name:");
                String firstname= inputuser.next();//firstname
                System.out.println("enter your secondname:");
                String lastname= inputuser.next();//secondname
                System.out.println("enter your age");
                int age = inputuser.nextInt();//age
                System.out.println("enter your nationality:");
                String nationality= inputuser.next();//nationality
                System.out.println("enter your subscribtion type:");
                String subscription= inputuser.next();//subscribtion type

                users.add(new User( age, nationality,subscription,  username,  password,  firstname, lastname, email));
            }
            else if(choice_login==2){
                System.out.println("can't register");

            }
        }


        public static void menu ()
        {
            Scanner inputuser= new Scanner(System.in);
            int choice_enterapp;
            //boolen flag=true;
            while(true){
                System.out.println("enter 1 for registration \n"+ "enter 2 for login" );
                choice_enterapp=inputuser.nextInt();
                if (choice_enterapp == 1)
                {
                    System.out.println(" WELCOME TO WATCHIT");
                    register( );
                    break;
                } else if (choice_enterapp ==2) {
                    System.out.println(" WELCOME TO WATCHIT");
                    login ();
                    break;
                }
                else {
                    System.out.println(" INVALID CHOICE ");

                }
            }




        }

        public static  personx login () {
            Scanner inputuser= new Scanner(System.in);
            ArrayList<User> users = new ArrayList();
            boolean pass=false;
            boolean flag_of_enter=false;


            System.out.println("enter your email ");
            do {

                String entered_email =inputuser .next();

                for (User u:users) {
                    if (entered_email.equals(u.getEmail())){
                        flag_of_enter=true;
                        do {


                            System.out.println("enter password:");
                            String passwordx = inputuser.next();
                            if (passwordx.equals(u.getPassword())) {
                                System.out.println("welcome");
                                pass=true;
                                return u;
                            } else {
                                System.out.println("invalid pssword and enter again");
                            }
                        }while (pass==false);
                    }
                    else{
                        System.out.println("invalid email enter again ");
                        menu();
                    }
                }
            }while (flag_of_enter==false);

            return null;
        }




























        // welcome msg:
        static void welcome(){
            System.out.println("Welcome to Watch It, where your movie experience is personalized just for you!\n" +
                    "Create your Watchlist to never miss a movie you want to see and easily access\n" +
                    "your Favorites for instant enjoyment. Our intelligent Recommendations engine\n" +
                    "tailors suggestions based on your preferences. Discover the Top 10 trending\n" +
                    "movies and explore films by searching through genres, actors, or directors.\n" +
                    "Manage your subscription seamlessly while enjoying uninterrupted streaming.\n" +
                    " Watch It – where every movie is a curated experience designed for your\n" +
                    "entertainment pleasure!");
            System.out.println("----------------------------------------------------------------------------------------");
            menu ();
           /* int btn;
            System.out.println("1. Log In");
            System.out.println("2. Register");
            Scanner scan = new Scanner(System.in);
            btn = scan.nextInt();
            boolean flag = false;
            do {
                if(btn == 1){
                    System.out.println("log");
                    flag = true;
                } else if (btn == 2) {
                    System.out.println("reg");
                    flag = true;
                }
                else{
                    flag = false;
                    System.out.println("Invalid Input, Try again!");
                    btn = scan.nextInt();
                }
            }while(flag == false);*/
        }
        //Discover page:
        static void DisplayUserDiscoverPg(){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Discover Page:");
            System.out.println("1. User Profile");
            System.out.println("2. Search");
            System.out.println("3. Display");

            int input;
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
            if(input == 1){
                UserProfile();
            } else if (input == 2) {
                Search();
            } else if (input == 3) {
                System.out.println("display f(x)");}
//            } else if (input == 4) {
//                System.out.println("fav");
//            } else if (input == 5) {
//                System.out.println("watch later");
//            } else if (input == 6) {
//                System.out.println("genre");
//            } else if (input == 7) {
//                System.out.println("cast:");
//                System.out.println("1. Actors\n2. Director\n3. Back");
//                int btn = scan.nextInt();
//                boolean flg = false;
//                do{
//                    if (btn == 1){
//                        System.out.println("call actors");
//                        flg = true;
//                    } else if (btn == 2) {
//                        System.out.println("call dir");
//                        flg = true;
//                    } else if (btn == 3) {
//                        DisplayUserDiscoverPg();
//                        flg = true;
//                    }else{
//                        System.out.println("Invalid Input, Try again!");
//                        flg = false;
//                        System.out.println("-------------------------------------------------------------------------------------");
//                        System.out.println("1. Actors\n2. Director\n3. Back");
//                        btn = scan.nextInt();
//                    }*/
//                }while (flg == false);
//            }else{
//                System.out.println("Invalid Input, Try again!");
//                DisplayUserDiscoverPg();
//            }
        }

        //User profile:
        static void UserProfile(){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("User profile:");//add f(x) edit user name and password
            System.out.println("1.delete\n2. Add\n3. Show \n4. Back");
            int btn; Scanner scan = new Scanner(System.in); btn = scan.nextInt();
            if(btn == 1){
                System.out.println("Call delete");
            } else if (btn == 2) {
                System.out.println("call add");
            } else if (btn == 3) {
                System.out.println("show:");
                }
             else if (btn == 4) {
                DisplayUserDiscoverPg();
            } else {
                System.out.println("Invalid Input, Try again!");
                UserProfile();
            }
        }

        // Search:
        static void Search(){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Search Page:");
            System.out.println("Search by:");
            System.out.println("1. Movie\n2. Actor\n3. Director\n4. Genre\n5. Back");
            int btn; Scanner scan = new Scanner(System.in); btn = scan.nextInt();
            if(btn == 1){
                MovieSearch();
            } else if (btn == 2) {
                System.out.println("call search actor");
            } else if (btn == 3) {
                System.out.println("call search Director");
            } else if (btn == 4) {
                System.out.println("call search genre");
            } else if (btn == 5) {
                DisplayUserDiscoverPg();
            } else {
                System.out.println("Invalid Input, Try again!");
                Search();
            }
        }

        // Show Movie:  Not Done
        static void ShowMovie(Movie movie){
            System.out.println("--------------------------------------------------------------------------");
            //call function read in movie
            System.out.println("1. Watch\n2. Rate\n3. Add to favourite\n4. Add to watch later\n5. show movie genere\n6. Back");
            int input;Scanner scan = new Scanner(System.in); input = scan.nextInt();
            if(input == 1){
                System.out.println("call watch");
            } else if (input == 2) {
                System.out.println("call edit Rate");
            } else if (input == 3) {
                System.out.println("call Add to favourite");
            } else if (input == 4) {
                System.out.println("call watch later");
                WatchLater.DisplayWatchLater();
            } else if (input == 5) {
                System.out.println("call show movie genere");

            } else if (input == 6) {
                DisplayUserDiscoverPg();
            } else {
                System.out.println("Invalid Input, Try again!");
                ShowMovie(movie);
            }
        }

        static void MovieSearch(){
            String name;
            Scanner scan = new Scanner(System.in);
            name = scan.nextLine();
            Movie.MovieSearch(name);
        }
    }

