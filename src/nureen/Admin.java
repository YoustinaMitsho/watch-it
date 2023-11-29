package nureen;

import mitsho.Basic;
import mitsho.Genre;
import mitsho.Movie;
import mitsho.Subscription;
import person_based_movies.cast;
import person_based_movies.director;

import java.util.*;

public class Admin extends personx {
    Subscription sub = new Subscription();

    ArrayList<String> movies = new ArrayList<String>();
    ArrayList<Movie> moviesList = new ArrayList<Movie>();
    ArrayList<String> moviescategory = new ArrayList<String>();///arraylist of categories 3nd youstine
    ArrayList<Movie> MoviesList = new ArrayList<>();
    ArrayList<cast> MovieCast = new ArrayList<>();
    ArrayList<Genre> MovieGenre = new ArrayList<>();

    ArrayList<director> MovieDirector = new ArrayList<>();

    private void add_movie(Movie addmovie) {
        MoviesList.add(addmovie);
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
    public void AddDirector(director d) {
        MovieDirector.add(d);
    }
    public void AddCast(cast c) {
        MovieCast.add(c);
    }
    public void AddGenre(Genre G) {
        MovieGenre.add(G);
    }

    public void displayplannumbers() {
        if (Subscription.PlanACounter > Subscription.PlanBCounter) {
            if (Subscription.PlanACounter > Subscription.PlanCCounter && Subscription.PlanCCounter > Subscription.PlanBCounter) {
                System.out.println("basic    " + Subscription.PlanACounter + " \n" + "  premium     " + Subscription.PlanCCounter + "/n" + "standard     " + Subscription.PlanBCounter);

            } else if (Subscription.PlanACounter > Subscription.PlanCCounter && Subscription.PlanCCounter < Subscription.PlanBCounter) {
                System.out.println("basic    " + Subscription.PlanACounter + " \n" + "standard     " + Subscription.PlanBCounter + "\n" + "  premium     " + Subscription.PlanCCounter);
            }
        } else if (Subscription.PlanBCounter > Subscription.PlanACounter) {
            if (Subscription.PlanBCounter > Subscription.PlanCCounter && Subscription.PlanCCounter > Subscription.PlanACounter) {
                System.out.println("standard" + Subscription.PlanBCounter + "\n" + "premium " + Subscription.PlanCCounter + "\n" + " basic " + Subscription.PlanACounter);
            } else if (Subscription.PlanBCounter > Subscription.PlanCCounter && Subscription.PlanCCounter < Subscription.PlanACounter) {
                System.out.println("standard" + Subscription.PlanBCounter + "\n" + " basic " + Subscription.PlanACounter + "\n" + "premium " + Subscription.PlanCCounter);
            }
        } else if (Subscription.PlanCCounter > Subscription.PlanBCounter) {
            if (Subscription.PlanCCounter > Subscription.PlanACounter && Subscription.PlanACounter > Subscription.PlanBCounter) {
                System.out.println(" premium " + Subscription.PlanCCounter + "\n" + "basic " + Subscription.PlanACounter + "\n" + "standard" + Subscription.PlanBCounter);
            } else if (Subscription.PlanCCounter > Subscription.PlanACounter && Subscription.PlanACounter < Subscription.PlanBCounter) {
                System.out.println(" premium " + Subscription.PlanCCounter + "\n" + "standard" + Subscription.PlanBCounter + "\n" + "basic " + Subscription.PlanACounter);
            }
        }
    }

    private int DisplayRevenu() {
        return sub.CalcRevenu();


    }


}