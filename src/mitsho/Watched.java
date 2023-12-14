package mitsho;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Watched extends Movie{

   static ArrayList<Movie> watchedlist =new ArrayList<Movie>();

    public Watched(int movieId, String movieTitle, Date movieDate, int movieTime, String movieLanguage, double IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating, String Discription, ArrayList<Movie> watchedlist) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating, Discription);
        this.watchedlist = watchedlist;
    }

    public Watched(boolean is_watched, String which){
        super(is_watched, "watched");
    }

    protected void AddWatched() {
        for (Movie watchedMovie : MoviesList)
            if (is_watched) {
                watchedlist.add(watchedMovie);
            }
    }
    public static void DisplayWatched(){
        for (Movie movies:watchedlist ){
            System.out.println(movies.MovieTitle);
        }
    }
}
