import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class d{
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);

        System.out.print("Enter number of elememnts ");
        int n=s.nextInt();

        ArrayList<Integer> arr=new ArrayList<>(n);

        System.out.println("Enter elements");

        for(int i=0;i<n;i++){
            arr.add(s.nextInt());
        }

        int max=Collections.max(arr);
        int min=Collections.min(arr);

        System.out.println("Max difference max-min = "+(max-min));

    }
}