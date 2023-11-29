import java.awt.*;
import java.util.ArrayList;

public class WatchLater extends Movie implements ReadFileByLineExample {

    ArrayList<Movie> WatchedLater=new ArrayList<Movie>();
    public WatchLater(int movieId, String movieTitle, String movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating);
    }

    public WatchLater(boolean watchlater, String which) {
        super(watchlater, which);
    }
    protected void Addwatchlater(){
        for (Movie WatchLaterMovie:MoviesList) {
            if(is_watchlater){
                WatchedLater.add(WatchLaterMovie);
            }
        }
    }

}
