package nureen;

import mitsho.Movie;
import person_based_movies.cast;

import java.util.*;

public class Admin extends personx {
    ArrayList<String> movies = new ArrayList<String>();
    ArrayList<Movie> moviesList = new ArrayList<Movie>();
    ArrayList<String> moviescategory = new ArrayList<String>();///arraylist of categories 3nd youstine

    private void add_movie(String addmovie, String categories) {
        ///arrayoflist of movies 3nd youstina
        movies.add(addmovie);
        moviescategory.add(addmovie);
        //add director and cast
        System.out.println("movie is added successfully!!");
    }

    private void remove_movie(String removedmovie, String category) {
        ArrayList<String> movies = new ArrayList<String>();///arrayoflist of movies 3nd youstina
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).equals(removedmovie)) {
                movies.remove(i);
            }
        }

        ArrayList<String> moviescategory = new ArrayList<String>();///arrayoflist of movies 3nd youstina
        for (int i = 0; i < moviescategory.size(); i++) {
            if (moviescategory.get(i).equals(category)) {
                moviescategory.remove(i);
            }
        }
    }

    public void displayplannumbers() {
        if (basic_counter > standard_counter) {
            if (basic_counter > premium_counter && premium_counter > standard_counter) {
                System.out.println("basic    " + basic_counter + " \n" + "  premium     " + premium_counter + "/n" + "standard     " + standard_counter);

            } else if (basic_counter > premium_counter && premium_counter < standard_counter) {
                System.out.println("basic    " + basic_counter + " \n" + "standard     " + standard_counter + "\n" + "  premium     " + premium_counter);
            }
        } else if (standard_counter > basic_counter) {
            if (standard_counter > premium_counter && premium_counter > basic_counter) {
                System.out.println("standard" + standard_counter + "\n" + "premium " + premium_counter + "\n" + " basic " + basic_counter);
            } else if (standard_counter > premium_counter && premium_counter < basic_counter) {
                System.out.println("standard" + standard_counter + "\n" + " basic " + basic_counter + "\n" + "premium " + premium_counter);
            }
        } else if (premium_counter > standard_counter) {
            if (premium_counter > basic_counter && basic_counter > standard_counter) {
                System.out.println(" premium " + premium_counter + "\n" + "basic " + basic_counter + "\n" + "standard" + standard_counter);
            } else if (premium_counter > basic_counter && basic_counter < standard_counter) {
                System.out.println(" premium " + premium_counter + "\n" + "standard" + standard_counter + "\n" + "basic " + basic_counter);
            }
        }
    }




}