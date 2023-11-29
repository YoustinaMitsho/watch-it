import java.awt.*;
import java.util.ArrayList;

public class Favourite extends Movie {

    ArrayList<Movie>FavouriteList=new ArrayList<Movie>();
    public Favourite(int movieId, String movieTitle, String movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating);
    }

    public Favourite(boolean fav, String which){
        super(fav, "fav");
    }
    protected void AddFavouritemovie(){
        for (Movie FavouriteMovie: MoviesList) {
            if(is_favourite){
                FavouriteList.add(FavouriteMovie);
            }
        }
    }
}
