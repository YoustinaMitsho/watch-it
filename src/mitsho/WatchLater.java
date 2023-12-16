package mitsho;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

public class WatchLater extends Movie {

   static ArrayList<Movie> WatchedLater=new ArrayList<Movie>();

    public WatchLater(int movieId, String movieTitle, Date movieDate, int movieTime, String movieLanguage, double IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating, String Discription, ArrayList<Movie> watchedLater) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating, Discription);
        WatchedLater = watchedLater;
    }

    public WatchLater(boolean watchlater, String which) {
        super(watchlater, "watchlater");
    }
    protected static void Addwatchlater(){
        for (Movie WatchLaterMovie:MoviesList) {
            if(is_WatchLater){
                WatchedLater.add(WatchLaterMovie);
            }
        }
    }

  /*protected static void addmovielater(int n)
  {
      for (Movie movie: MoviesList) {
          if(movie.MovieId==(n)){
              WatchedLater.add(movie.MovieTitle);
          }
      }

  }*/

    public static void RemoveMovieFromWatchLater(String MovieName){
        for (Movie movie: WatchedLater) {
            if(movie.equals(MovieName)){
                WatchedLater.remove(movie);
            }
        }
    }
    protected static void DisplayWatchLater(){
        for (Movie movies:WatchedLater ){
            System.out.println(movies.MovieTitle);
        }
    }
}
