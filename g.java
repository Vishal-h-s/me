import java.util.Scanner;

public class g{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first sting: ");
        String s1=sc.nextLine();
        System.out.print("Enter 2nd string: ");
        String s2=sc.nextLine();

        sc.close();

        int m=s1.length(),n=s2.length();
        int dp[][]=new int[m+1][n+1];
        dp[0][0]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        System.out.println("LCS = "+dp[m][n]);
    }
}