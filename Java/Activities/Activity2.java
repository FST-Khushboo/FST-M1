package activities;



public class Activity2 {

    public static void main(String[] args)
    {
        int[] array = {10,77,10,54,-11,10};
        int sum=0;
        for(int i =0; i<=5; i++)
            if (array[i] == 10)
                sum +=10;
        if(sum==30)
        {
            System.out.println(sum);
            System.out.println(sum +"=30");
        }



    }

}
