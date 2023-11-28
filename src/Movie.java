
import java.awt.*;
import java.util.ArrayList;

public class Movie {
    ArrayList<Movie> MoviesList = new ArrayList<Movie>();
    public int MovieId;
    public String MovieTitle;
    public String MovieDate;
    public int MovieTime;
    //ArrayList<Cast> MovieCast;   // Cast class to be done later
    ArrayList<Genre> MovieGenre = new ArrayList<Genre>(); // Genre class to be done later
    //List<Director> MovieDirector  // Director class to be done later
    public String MovieLanguage; // Is it a class like director?
    public int IMDB_Score;
    public String MovieCountry;
    public int MovieBudget;
    public int MovieRevenue;
    public static boolean is_watched;
    public Image MoviePoster;

    public Movie(int movieId, String movieTitle, String movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster) {
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
    }

    public String getMovieTitle() {
        return MovieTitle;
    }

    public boolean isIs_watched() {
        return is_watched;
    }

    public ArrayList<Movie> MovieSearch(String MovieName){
        ArrayList<Movie> result = new ArrayList<Movie>();
        for (Movie movie : MoviesList) {
            if(MovieName.equals(movie.getMovieTitle())){
                result.add(movie);
            }
        }
        return result;
    }

    protected void AddGenre(String MovieName, Genre genre){
        for(Movie movie: MoviesList){
            if(MovieName.equals(movie.getMovieTitle())){
                this.MovieGenre.add(genre);
            }
        }
    }

    public ArrayList<Genre> ShowMovieGenre(String MovieName){
        for (Movie movie: MoviesList) {
            if(MovieName.equals(movie.getMovieTitle())){
                return movie.MovieGenre;
            }
        }
        return null;
    }

    // show movie cast w director


}
