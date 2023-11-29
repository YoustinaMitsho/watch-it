
import java.time.LocalDate;

public class Subscription implements ReadFileByLineExample{
    protected int UserId;
    private int PlanPrice;
    protected LocalDate StartDate;
    protected LocalDate EndDate = StartDate.plusDays(30);

    protected boolean is_paied;
    public static int PlanACounter = 0;
    public static int PlanBCounter = 0;
    public static int PlanCCounter = 0;
    public int Movienum;

    protected int defaultnum;
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
    protected void Subscriptionrenew(){
        LocalDate today = LocalDate.now();
        if(is_paied && today.isEqual(EndDate)){
            Movienum = defaultnum;
        }
    }

    //revenue
    protected int CalculateRevenue(){
        return (PlanPrice * PlanACounter) +  (PlanPrice * PlanBCounter) +  (PlanPrice * PlanCCounter);
    }

    //most subscriped plan

}
