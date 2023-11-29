package mitsho;

import java.time.LocalDate;

public class Subscription {
    protected int UserId;
    private int PlanPrice;
    protected LocalDate StartDate;
    protected LocalDate EndDate = StartDate.plusDays(30);

    public static int PlanCounter = 0;
    public int Movienum;
    private void MovieDecreaser(){
        if(Movie.is_watched && Movienum > 0){
            Movienum--;
        }
        else{
            System.out.println("Max Number of Movies is Reached");
        }
    }

    private void SubscriptionResetter(){
        LocalDate today = LocalDate.now();
        if(today.isEqual(EndDate)){
            Movienum = 0;
        }
    }

    //ygded el subscription
    //most subscriped plan
    //revenue

}
