import java.util.Scanner;

// import java.ut
public class b {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter ");
        int N = s.nextInt();
        s.close();
        boolean flag = true;
        if (N < 100) {
            flag = false;
        } else {
            String str = Integer.toString(N);
            String str2 = str.charAt(0) + "" + str.charAt(str.length() - 1);
            int num = Integer.parseInt(str2, 10);
            if (N % num != 0)
                flag = false;
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
