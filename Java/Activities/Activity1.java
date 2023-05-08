package activities;

public class Activity1 {
    public static void main(String[] args)
    {
        Car carName = new Car();
       carName.make=2014;
       carName.transmission="Manual";
       carName.colour="Red";

        int make = 2014;
        String transmission ="Manual";
        System.out.print("\n CHARACTERISTICS OF THE CAR ");
        carName.displayCharacteristics();
        System.out.print("\n FUNCTION OF  ACCELARATER ");
        carName.accelarate();
        System.out.print("\n FUNCTION OF BRAKE");
        carName.brake();
    }






}
class Car  {
    String colour ;
    String transmission;
    int make ;
    int tyres;
    int doors;
   Car()
   {
       tyres=4;
       doors=4;
   }
 public void displayCharacteristics()
 {
     System.out.print( "\n colour of the car=" +colour );
     System.out.print( "\n Tansmission of the car=" +transmission );
     System.out.print( "\n No. of  tyres in the car=" +tyres );
     System.out.print( "\n No. of  doors in the car=" +doors );

 }
public void accelarate()
{
    System.out.print( "\n Car is moving forward" );
}
public void brake()
{
    System.out.print( "\n Car has stopped" );
}



}