import java.awt.*;
import java.util.ArrayList;

public class Watched extends Movie implements ReadFileByLineExample{

ArrayList<Movie> watchedlist =new ArrayList<Movie>();

    public Watched(int movieId, String movieTitle, String movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating);
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

}
