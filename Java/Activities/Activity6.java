package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    Plane (int maxPassengers)
    {
       this.passengers= new ArrayList<>();

    }
    public void onboard( String passengers )
    {
        this.passengers.add(passengers);
    }
   public Date takeOff()
   {
       lastTimeTookOf = new Date();
       return lastTimeTookOf;
   }
   public void land()
   {
       lastTimeLanded = new Date();
       this.passengers.clear();
   }
   public Date getLastTimeLanded()
   {
       return lastTimeLanded;
   }
   public List<String> getPassesngers()
   {
       return passengers;
   }

}
class Activity6
{
    public static void main(String[] args) throws InterruptedException {
        Plane obj = new Plane(10);
        obj.onboard("kayal");
        obj.onboard("karthika");
        obj.onboard("kavin");

        System.out.print("Take off time= " + obj.takeOff());
        System.out.print(" \n list of passengers=" +obj.getPassesngers());
        Thread.sleep(5000);
        obj.land();
        System.out.print("\n landed time =" +obj.getLastTimeLanded());

    }
}