import java.util.Scanner;

public class a {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);//declaration
        System.out.print("Enter ");//prompt
        int N=s.nextInt();//input
        s.close();
        System.out.println("i j (<"+N+")");//output
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                if(i==(j+1)*j){
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}