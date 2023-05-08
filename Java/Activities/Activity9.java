package activities;

import java.util.ArrayList;

public class Activity9
{
    public static void main(String[] args)
    {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Kayal");
        myList.add("karthi");
        myList.add("Kavin");
        myList.add("Kavin");
        myList.add("karthika");
        System.out.print("all object ");
        /*for (String x:myList)
        {
            System.out.println(myList);
        }*/

        for (int i = 0 ;i< myList.size();i++ )
        {
            System.out.println(myList.get(i));
        }
        System.out.print(" \n retrieve the 3rd name in the ArrayList =  " +myList.get(2));
        System.out.print(" \n Check if a name exists in the ArrayList = " +myList.contains("Kavin"));
        System.out.print(" \n Print the number of names in the ArrayList =  " +myList.size());
        myList.remove(3);
        System.out.print("\n Print the number of names in the ArrayList after deletion = " +myList.size());

    }




}
