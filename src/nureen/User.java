package nureen;
import mitsho.*;
import person_based_movies.cast;
import person_based_movies.director;
import javax.swing.plaf.SplitPaneUI;
import java.util.*;

public class User extends personx implements ReadFiles {
    int age; //3shan offer films related

    String subscrebtion_type;
    public User(int id,String username,int password,String Fname,String Lname,String email,int age,String nationality,String subscrebtiontype){
        super( id, username,  password,  Fname,  Lname,  email);
        this.age=age;
        this.nationality=nationality;
        this.subscrebtion_type=subscrebtiontype;
    }
    Subscription subscriptionPlan = new Subscription();
    String nationality;//3shan offer films related
    ArrayList<Watched> alreadyWatched = new ArrayList<>();
    ArrayList<Favourite> FavouriteMovies = new ArrayList<>();
    ArrayList<WatchLater> WatchLaterList = new ArrayList<>();
    ArrayList<Movie> MoviesList = new ArrayList<>();
    ArrayList<cast> MovieCast = new ArrayList<>();

    ArrayList<director> MovieDirector = new ArrayList<>();

    public ArrayList<Movie> MovieSearch(String MovieName) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                result.add(movie);
            }
        }
        return result;
    }

    public ArrayList<cast> SearchCastByName(String name) {
        ArrayList<cast> result = new ArrayList<cast>();
        for (cast castData : MovieCast) {
            if (name.equals(castData.F_name)) {
                result.add(castData);
            }
        }
        return result;
    }

    public ArrayList<director> SearchDirectorByName(String name) {
        ArrayList<director> result = new ArrayList<director>();
        for (director DirectorData : MovieDirector) {
            if (name.equals(DirectorData.F_name)) {
                result.add(DirectorData);
            }
        }
        return result;
    }

    public String  display(){
        // String = (id+","username, pass,String Fname,String Lname,String email,int age,String nationality,String subscrebtiontype
        int iid=getId();
        return getId()+","+getUsername()+","+getPassword()+","+firstname+","+lastname+","+getEmail()+","+age+","+nationality+","+subscrebtion_type;

    }



}
