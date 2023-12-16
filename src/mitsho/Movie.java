package mitsho;

import person_based_movies.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.List;

public class Movie {
   static ArrayList<Movie> MoviesList = new ArrayList<Movie>();
    public int MovieId;
    public String MovieTitle;
    public Date MovieDate;
    public int MovieTime;
    ArrayList<cast> MovieCast = new ArrayList<cast>();   // Cast class to be done later
    ArrayList<Genre> MovieGenre = new ArrayList<Genre>(); // Genre class to be done later
    ArrayList<director> MovieDirector = new ArrayList<director>();  // Director class to be done later
    public String MovieLanguage; // Is it a class like director?
    public Double IMDB_Score;
    public double UserRating;
    public String MovieCountry;
    public int MovieBudget;
    public int MovieRevenue;
    public static boolean is_watched;
    public static boolean is_favourite;
    public static boolean is_WatchLater;
    public Image MoviePoster;
    public String discription;
    public Movie(int movieId, String movieTitle, Date movieDate, int movieTime, String movieLanguage, Double IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster,double UserRating,String Discription) {
        MovieId = movieId;
        MovieTitle = movieTitle;
        MovieDate = movieDate;
        MovieTime = movieTime;
        MovieLanguage = movieLanguage;
        this.IMDB_Score = IMDB_Score;
        MovieCountry = movieCountry;
        MovieBudget = movieBudget;
        MovieRevenue = movieRevenue;
        MoviePoster = moviePoster;
        this.UserRating=UserRating;
        this.discription=Discription;
    }

    public Movie(boolean Is_it, String which){
        if(which.equals("fav")){
            this.is_favourite = Is_it;
        } else if (which.equals("watched")) {
            this.is_watched = Is_it;
        }
        else if (which.equals("watchlater")){
            this.is_WatchLater = Is_it;
        }
    }

    public String getMovieTitle() {
        return MovieTitle;
    }

    public Double getIMDB_Score() {
        return IMDB_Score;
    }

    //public boolean isIs_watched() {
    //return is_watched;
    //}

    public static void MovieSearch(String MovieName) {

        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                System.out.println(movie.discription);
            }
            else{
                System.out.println(" sorry this movie is not found");
            }
        }
    }
   public static void MovieSearch_bydirector(String directorFname,String directorLname) {
       for (director director : director.director_list) {
           if (directorFname.equals(director.F_name) && directorLname.equals(director.L_name)) {
               System.out.println( "his firstname:"+director.F_name );
               System.out.println("his lastname:" + director.L_name);
               System.out.println( " his nationality:"+director.Nationality);
               System.out.println( "his director Age"+director.Age);
               for (Movie movie : MoviesList) {
                   if ((directorFname+" "+directorLname).equals(movie.MovieDirector)) {
                       System.out.println(movie.getMovieTitle());

                   } else {
                       System.out.println(" this director has no movies");
                   }
               }
           }
       }
   }


    public static void MovieSearch_byActor(String ActorFname,String ActorLname) {
        for (cast cast : cast.cast_list) {
            if (ActorFname.equals(cast.F_name) && ActorLname.equals(cast.L_name)) {
                System.out.println( "his firstname:"+cast.F_name );
                System.out.println("his lastname:" + cast.L_name);
                System.out.println( " his nationality:"+cast.Nationality);
                System.out.println( "his director Age"+cast.Age);
                for (Movie movie : MoviesList) {
                    if ((ActorFname+" "+ActorLname).equals(movie.MovieDirector)) {
                        System.out.println(movie.getMovieTitle());

                    } else {
                        System.out.println("  no movies");
                    }
                }
            }
        }
    }
    protected void AddGenre(String MovieName, Genre genre) {
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                this.MovieGenre.add(genre);
            }
        }
    }

    public static  ArrayList<Genre> ShowMovieGenre(String MovieName) {
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                return movie.MovieGenre;
            }
        }
        return null;
    }

    // show movie cast w director
    /*public void AddCast(cast c) {
        MovieCast.add(c);
    }*/

    /*public void AddDirector(director d) {
        MovieDirector.add(d);
    }*/

    /*public ArrayList<cast> SearchCastByName(String name) {
        ArrayList<cast> result = new ArrayList<cast>();
        for (cast castData : MovieCast) {
            if (name.equals(castData.F_name)) {
                result.add(castData);
            }
        }
        return result;
    }*/
   /* public ArrayList<director> SearchDirectorByName(String name) {
        ArrayList<director> result = new ArrayList<director>();
        for (director DirectorData : MovieDirector) {
            if (name.equals(DirectorData.F_name)) {
                result.add(DirectorData);
            }
        }
        return result;

    }*/

    public ArrayList<Movie> UpCommingMovies(){
        ArrayList<Movie> UpCommingMovie = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate localDateFromMovieDate = this.MovieDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(today.isBefore(localDateFromMovieDate)){
            UpCommingMovie.add(this);
        }
        return UpCommingMovie;
    }

    public static List<Movie> TopMovies(){
        Collections.sort(MoviesList, Comparator.comparingDouble(Movie::getIMDB_Score).reversed());
        List<Movie> top10Movies = MoviesList.subList(0, Math.min(MoviesList.size(), 10));
        return top10Movies;
    }
    public static void DisplayAllMovies() {

        for (Movie movie : MoviesList) {
            System.out.println(movie.MovieTitle);
        }

    }

}
