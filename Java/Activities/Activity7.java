package activities;
interface BicycleParts
{
    public int gears = 0;
    public int speed=0;

}
interface BicycleOperations
{
    public  void applyBrake(int decrement);

    public  void  speedUp(int increment);
}
class Bicyle implements BicycleParts, BicycleOperations
{

  public int gears;
  public int currentSpeed;
    public void Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    @Override
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println(currentSpeed);
    }

    @Override
    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println(currentSpeed);
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\n Speed of bicycle is " + currentSpeed);
    }
}
class MountainBike extends Bicyle
{
    public int seatHeight;

    public MountainBike(int gears, int currentSpeed, int startHeight) {
        super();
        this.gears = gears;
        this.currentSpeed = currentSpeed;
        seatHeight = startHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    @Override
    public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }
    public static void main(String args[]) {
        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }

}
