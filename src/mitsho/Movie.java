package mitsho;

import person_based_movies.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    ArrayList<Movie> MoviesList = new ArrayList<Movie>();
    public int MovieId;
    public String MovieTitle;
    public Date MovieDate;
    public int MovieTime;
    ArrayList<cast> MovieCast = new ArrayList<cast>();   // Cast class to be done later
    ArrayList<Genre> MovieGenre = new ArrayList<Genre>(); // Genre class to be done later
    ArrayList<director> MovieDirector = new ArrayList<director>();  // Director class to be done later
    public String MovieLanguage; // Is it a class like director?
    public int IMDB_Score;
    public double UserRating;
    public String MovieCountry;
    public int MovieBudget;
    public int MovieRevenue;
    public static boolean is_watched;
    public  boolean is_favourite;
    public boolean is_WatchLater;
    public Image MoviePoster;
    public String discription;
    public Movie(int movieId, String movieTitle, Date movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster,double UserRating,String Discription) {
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

    //public boolean isIs_watched() {
        //return is_watched;
    //}

    /*public ArrayList<Movie> MovieSearch(String MovieName) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                result.add(movie);
            }
        }
        return result;
    }*/

    protected void AddGenre(String MovieName, Genre genre) {
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                this.MovieGenre.add(genre);
            }
        }
    }

    public ArrayList<Genre> ShowMovieGenre(String MovieName) {
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

    /*public List<Movie> TopMovies(){
        Movie[] topmovies = TopMovies().toArray(new Movie[10]);
        // probably will use comprator interface
        // to be studied then implemented
    }*/
}
