package activities;

public class Activity3 {
    public static void main(String[] args)
    {
        double seconds = 1000000000;

        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;
        System.out.println("Age of earth seconds=" +seconds/EarthSeconds);
        System.out.println("Age of Mercury seconds=" +seconds/MercurySeconds/EarthSeconds);
        System.out.println("Age of Venus seconds=" +seconds/VenusSeconds/EarthSeconds);
        System.out.println("Age of Mars seconds=" +seconds/MarsSeconds/EarthSeconds);
        System.out.println("Age of jupiter seconds=" +seconds/JupiterSeconds/EarthSeconds);
        System.out.println("Age of Saturn seconds=" +seconds/SaturnSeconds/EarthSeconds);
        System.out.println("Age of Uranus seconds=" +seconds/UranusSeconds/EarthSeconds);
        System.out.println("Age of Neptune seconds=" +seconds/NeptuneSeconds/EarthSeconds);

    }
}
