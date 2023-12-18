package mitsho;
import nureen.*;
import person_based_movies.*;
import nureen.User;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

import static nureen.Admin.displayplannumbers;
import static nureen.Admin.getInstance;
import static nureen.User.calculateMostRevenueMonth;

public class Main {
    public static void main(String args[]) throws IOException {
        ArrayList<User> user = User.Read("oop_prpject_user_data.txt");
        ArrayList<Movie> movie = Movie.Read("OOP_Movies.txt");
        ArrayList<director> Director = director.Read("movie_persion_di.txt");
        ArrayList<cast> Cast = cast.Read("movie_persion_ca.txt");
        Admin admin = Admin.getInstance();
        welcome(user, movie,admin);
        //DisplayUserDiscoverPg(user , movie);
        //UserProfile();
    }

    public static void  register(ArrayList<User> user, ArrayList<Movie> movies,Admin admin) {
        Scanner inputuser = new Scanner(System.in);
        String email;
        while (true) {
            System.out.println("enter your email:");
            email = inputuser.next();//email
            if (email.matches("^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(gmail\\.com|yahoo\\.com)$")) {
                break;
            } else {
                System.out.println("invalid email.make use to add \"@gmail.com\"or \"@yahoo.com\"");
            }
        }
        System.out.println("enter your username:");
        String username = inputuser.next();//username
        int password;
        while (true) {
            System.out.println("Enter integer password");
            if (inputuser.hasNextInt()) {
                password = inputuser.nextInt();

                // Convert the integer to a string to get its length
                String inputString = Integer.toString(password);

                // Check if the length is between 8 and 16 (inclusive)
                if (inputString.length() >= 8 && inputString.length() <= 16) {
                    break;
                } else {
                    System.out.println("Invalid input length. It should be between 8 and 16.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        String firstname;
        while (true) {
            System.out.println("enter your first name:");
            firstname = inputuser.next();//secondname
            if (firstname.matches("^[a-zA-z]+$")) {
                break;
            } else {
                System.out.println("invalid name, please enter letters only");
            }
        }
        String lastname;
        while (true) {
            System.out.println("enter your last name:");
            lastname = inputuser.next();//secondname
            if (lastname.matches("^[a-zA-z]+$")) {
                break;
            } else {
                System.out.println("invalid name, please enter letters only");
            }
        }
        int age;
        while (true) {
            System.out.print("Enter an integer age: ");
            if (inputuser.hasNextInt()) {
                age = inputuser.nextInt();
                break; // exit the loop if a valid integer is entered
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                inputuser.next(); // consume the invalid input to prevent an infinite loop
            }
        }
        String nationality;
        while (true) {
            System.out.println("enter your nationality:");
            nationality = inputuser.next();//secondname
            if (nationality.matches("^[a-zA-z]+$")) {
                break;
            } else {
                System.out.println("invalid nationality, please enter letters only");
            }
        }
        String subscription;
        while (true) {
            System.out.println("enter your subscribtion type: (basic or standard or premium )");
            subscription = inputuser.nextLine();
            if (subscription.toLowerCase().equals("basic") || subscription.toLowerCase().equals("standard") || subscription.toLowerCase().equals("premium")) {
                System.out.println("registration suceesful! welcome");
                break;
            } else {
                System.out.println("invalid choice");

            }
        }
        int month;
        while (true){
            System.out.println("enter your current month");
            month=inputuser.nextInt();
            if (month > 0 && month < 13) {
                System.out.println(" month added");
                break;
            } else {
                System.out.println("invalid choice");

            }
        }
        User u = (User) user.get(user.size() - 1);
        int idnew = u.id + 1;

        user.add(new User(idnew, username, password, firstname, lastname, email, age, nationality, subscription.toLowerCase(),month));
        login_user(user, movies,admin);
    }

    public static void menu (ArrayList<User> user, ArrayList<Movie> movies,Admin admin) {
        Scanner inputuser = new Scanner(System.in);
        int choice2_enterapp;
        int choice_enterapp;
        //boolen flag=true;
        while (true) {
            System.out.println("enter 1 for registration \n" + "enter 2 for login");
            choice_enterapp = inputuser.nextInt();
            if (choice_enterapp == 1) {
                System.out.println("WELCOME TO WATCHIT");
                register(user, movies, admin);
                break;
            } else if (choice_enterapp == 2) {
                System.out.println("enter 1  login AS ADMIN \n" + "enter 2 login AS USER \n" + "enter 3 to BACK \n");
                choice2_enterapp = inputuser.nextInt();
                if (choice2_enterapp == 1) {
                    System.out.println("WELCOME ADMIN  TO WATCHIT");
                    login_admin(user, movies, admin);
                }
                if (choice2_enterapp == 2) {
                    System.out.println("WELCOME USER TO WATCHIT");
                    System.out.println("WELCOME USER  TO WATCHIT");
                    login_user(user, movies, admin);
                    break;
                } else {
                    System.out.println("INVALID CHOICE ");

                }
            }
        }
    }

        public static  void login_admin (ArrayList<User> user, ArrayList<Movie> movies,Admin admin) {
            System.out.println("-----------");
            Scanner inputadmin= new Scanner(System.in);
            System.out.println("enter your email ");
            String entered_email =inputadmin.next();
            int entered_pass;
            if(entered_email.equals(admin.getEmail()))
            {
                do{
                    System.out.println("enter password");
                    entered_pass= inputadmin.nextInt();
                    if(entered_pass==admin.getPassword())
                    {
                        AdminProfile( user, movies, admin);
                        break;
                    }
                    else {
                        System.out.println("incorrect password!!");
                    }
                }while(entered_pass==admin.getPassword());
            }
            else {
                System.out.println("INVALID");
            }
        }


    public static  void login_user (ArrayList<User> user, ArrayList<Movie> movies,Admin admin) {
        System.out.println("-----------");
        System.out.println("Welcome  user to Login:");
        Scanner inputuser= new Scanner(System.in);
        boolean pass=false;
        boolean flag_of_enter=false;
        System.out.println("enter your email ");
        String entered_email =inputuser.next();
        User userLogIn = null;
        do {
            for (User u:user) {
                if (entered_email.equals(u.getEmail())) {
                    flag_of_enter = true;
                }
                if (flag_of_enter == true) {
                    do {
                        System.out.println("enter password:");
                        int passwordx = inputuser.nextInt();
                        if (passwordx == u.getPassword()) {
                            System.out.println("welcome");
                            pass = true;
                            userLogIn = u;
                        } else {
                            System.out.println("invalid password, enter again");
                        }
                    } while (pass == false);
                }
                if(flag_of_enter && pass) break;
            }
        }while (flag_of_enter && !pass);
        if(!flag_of_enter){
            System.out.println("invalid email enter again ");
            menu(user, movies,admin);
        }
        if(pass){
            DisplayUserDiscoverPg(userLogIn, movies, user,getInstance());
        }
    }

    // welcome msg:
    static void welcome(ArrayList<User> user, ArrayList<Movie> movies,Admin admin){
        System.out.println("Welcome to Watch It, where your movie experience is personalized just for you!\n" +
                "Create your Watchlist to never miss a movie you want to see and easily access\n" +
                "your Favorites for instant enjoyment. Our intelligent Recommendations engine\n" +
                "tailors suggestions based on your preferences. Discover the Top 10 trending\n" +
                "movies and explore films by searching through genres, actors, or directors.\n" +
                "Manage your subscription seamlessly while enjoying uninterrupted streaming.\n" +
                " Watch It – where every movie is a curated experience designed for your\n" +
                "entertainment pleasure!");
        System.out.println("----------------------------------------------------------------------------------------");
        menu (user, movies,admin);
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
    static void DisplayUserDiscoverPg(User user, ArrayList<Movie> movies, ArrayList<User> users,Admin admin){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Discover Page:");
        System.out.println("1. User Profile");
        System.out.println("2. Search");
        System.out.println("3. Display");
        System.out.println("4.log out");

        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        if(input == 1){
            UserProfile(movies, user, users,admin);
        } else if (input == 2) {
            Search(movies, user, users,admin);
        } else if (input == 3) {
            displayMovies(user, movies, users,admin);}
//
        else if(input==4)
        {
            menu(users, movies,admin);
        }

        else{
            System.out.println("invalid choice!" );
            DisplayUserDiscoverPg(user, movies, users,admin);
        }

    }

    //User profile:
    static void UserProfile(ArrayList<Movie> movies, User user, ArrayList<User>users,Admin admin){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("User profile:");
        System.out.println("1.delete\n2.Add\n3.Show\n4.Back");
        int btn; Scanner scan = new Scanner(System.in); btn = scan.nextInt();
        if(btn == 1){
            System.out.println("1.delete watch later\n2.delete from your favourite\n3. delete watched  \n4. Back");
            int DeleteInput;
            DeleteInput = scan.nextInt();
            if(DeleteInput==1){
                Movie.DisplayAllMovies();
                System.out.println("enter movie you want to delete:");
                String movie=scan.next();
                WatchLater.RemoveMovieFromWatchLater(movie);
            }
            else if(DeleteInput==3){
                Movie.DisplayAllMovies();
                System.out.println("enter movie you want to delete:");
                String movie=scan.next();
                Watched.RemoveMovieFromWatched(movie);
            }
            else if(DeleteInput==2){
                Movie.DisplayAllMovies();
                System.out.println("enter movie you want to delete:");
                String movie=scan.next();
                Favourite.RemoveMovieFromFavourite(movie );
            }else if (DeleteInput==4){
                UserProfile(movies, user, users,admin);
            }
        } else if (btn == 2) {
            System.out.println("call add");
            System.out.println("1.add watch later\n2.add to your favourite\n 3. Back");
            int AddInput;AddInput = scan.nextInt();
            if(AddInput==1) {
                Movie.DisplayAllMovies();
                System.out.println("enter movie you want to add:");
                Movie.DisplayAllMovies();
                int choice = scan.nextInt();
                for (Movie m: movies) {
                    if(choice == m.MovieId){
                        m.is_WatchLater = true;
                        break;
                    }
                }
                WatchLater.Addwatchlater();
            }
            else if(AddInput==2){
                Movie.DisplayAllMovies();
                System.out.println("enter movie you want to add:");
                Movie.DisplayAllMovies();
                int choice = scan.nextInt();
                for (Movie movie: Movie.MoviesList) {
                    if(choice == movie.MovieId){
                        movie.is_favourite = true;
                        break;
                    }
                }
                Favourite.AddFavouritemovie();
            } else if (AddInput==3){
                UserProfile(movies, user, users,admin);
            }
        } else if (btn == 3) {
            System.out.println("show:");
            System.out.println("1.Display watch later\n2.Display to your favourite\n 3. Display watched\n 4.back ");
            int input= scan.nextInt();
            if (input==1) {
                System.out.println("watch later");
                WatchLater.DisplayWatchLater();
            }
            else if (input==2){
                System.out.println("Display to your favourite");
                Favourite.DisplayFavourite();
            }else if (input==3){
                System.out.println("Display watched");
                Watched.DisplayWatched();
            }else if (input==4){
                System.out.println("back");
                UserProfile(movies, user, users,admin);
            }

        }
        else if (btn == 4) {
            DisplayUserDiscoverPg(user, movies, users,admin);
        } else {
            System.out.println("Invalid Input, Try again!");
            UserProfile(movies, user, users,admin);
        }
    }

    // Search:
    static void Search(ArrayList<Movie> movies, User user, ArrayList<User> users,Admin admin) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Search Page:");
        System.out.println("Search by:");
        System.out.println("1. Movie\n2. Actor\n3. Director\n4. Genre\n5. Back");
        int btn; Scanner scan = new Scanner(System.in); btn = scan.nextInt();
        if(btn == 1){
            MovieSearch(); // not working
            Search(movies, user, users,admin);
        } else if (btn == 2) {
            System.out.println("call search actor");
            System.out.println("enter the first  name of actor you search for:");
            String ActorFname= scan.next();
            System.out.println("enter the second name of actor you search for:");
            String ActorLname= scan.next();
            Movie.MovieSearch_byActor( ActorFname, ActorLname); // not working
            Search(movies, user, users,admin);
        } else if (btn == 3) {
            System.out.println("call search Director");
            System.out.println("enter the first  name of director you search for:");
            String directorfname= scan.next();
            System.out.println("enter the second name of director you search for:");
            String directorlname= scan.next();
            Movie.MovieSearch_bydirector(directorfname,directorlname);
            Search(movies, user, users,admin);
        } else if (btn == 4) {
            System.out.println("enter genre:");
            String genre = scan.next();
            Movie.ShowMovieGenre(genre);
            Search(movies, user, users,admin);
        } else if (btn == 5) {
            DisplayUserDiscoverPg(user, movies, users,admin);
        } else {
            System.out.println("Invalid Input, Try again!");
            Search(movies, user, users,admin);
        }
    }

    static void ShowMovie(Movie movie, User user, ArrayList<Movie> movies, ArrayList<User> users,Admin admin){
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
            DisplayUserDiscoverPg(user, movies, users,admin);
        } else {
            System.out.println("Invalid Input, Try again!");
            ShowMovie(movie, user, movies, users,admin);
        }
    }

    static void MovieSearch(){
        String name;
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        Movie.MovieSearch(name);
    }
    static void displayMovies(User user, ArrayList<Movie> movies, ArrayList<User> users,Admin admin){
        Scanner sc= new Scanner(System.in);
        System.out.println("1.ALL MOVIES");
        System.out.println("2.TOP RATED MOVIES");
        System.out.println("3.RECENT MOVIES");
        System.out.println("4.Back");
        int choose= sc.nextInt();
        if (choose==1){
            Movie.DisplayAllMovies();
            displayMovies(user, movies, users,admin);
        }
        else if(choose==2){
            Movie.TopMovies(); // not working
            displayMovies(user, movies, users,admin);
        }
        else if(choose==3) {
            Movie.UpCommingMovies(); // not working
            displayMovies(user, movies, users,admin);

        }
        else if(choose==4){
            DisplayUserDiscoverPg(user, movies, users,admin);
        }
    }

     static void AdminProfile(ArrayList<User> user,ArrayList<Movie> movies,Admin admin) {
         Scanner inputAdmin = new Scanner(System.in);
         System.out.println("1-edit move info \n2-display the most subscribed plan\n3-display users data\n4-display month had the most revenue\n5-back");
         int admin_choice = inputAdmin.nextInt();
         if(  admin_choice == 1){
             EditedMovie( user, movies, admin);
         }
         else if ( admin_choice == 2) {
             displayplannumbers();
           //  most plan
         }
         else if ( admin_choice == 3) {
           //  displayMovies(user, movies, users,admin);
              }
         else if( admin_choice ==4)
         {
             calculateMostRevenueMonth(user);

         }
             else if( admin_choice ==5){
             menu(user,movies,admin);
             }


         else{
             System.out.println("invalid choice!" );

         }
         AdminProfile( user, movies, admin);

     }



    static void EditedMovie(ArrayList<User> user,ArrayList<Movie> movies,Admin admin){
        Scanner inputAdmin = new Scanner(System.in);
       //  DisplayMovieSToAdmin();
                System.out.println("---------------------------------------------------------------------------------------------------------" +
                         "\n1-add movie\n2-delete movie\n3-add genera\n4-edit cast\n5-add director\n6-back");
                 int AdminChoice2ToMovies = inputAdmin.nextInt();
        if(  AdminChoice2ToMovies == 1){
            //add_movie(Movie addmovie);
        }
        else if (  AdminChoice2ToMovies == 2) {
            displayplannumbers();
            //  remove_movie(String removedmovie, String category)
        }
        else if (  AdminChoice2ToMovies == 3) {
            //  displayMovies(user, movies, users,admin);
        }
        else if(  AdminChoice2ToMovies ==4)
        {
            //edit cast if you want

        }
        else if(  AdminChoice2ToMovies ==5){
           // add director if you want
        }
        else if(  AdminChoice2ToMovies ==6){
            AdminProfile( user, movies, admin);
        }


        else{
            System.out.println("invalid choice!" );

        }
        EditedMovie( user, movies, admin);
    }

}