package mitsho;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Favourite extends Movie {

    ArrayList<Movie>FavouriteList=new ArrayList<Movie>();

    public Favourite(int movieId, String movieTitle, Date movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating, String Discription, ArrayList<Movie> favouriteList) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating, Discription);
        FavouriteList = favouriteList;
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

    protected void RemoveMovieFromFavourite(String MovieName){
        for (Movie movie: FavouriteList) {
            if(movie.equals(MovieName)){
                FavouriteList.remove(movie);
            }
        }
    }
}
