import java.util.Scanner;

public class e {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] m = new int[n][n];
        int rowbegin = 0, colbegin = 0, rowend = n - 1, colend = n - 1;

        while (rowbegin <= rowend && colbegin <= colend) {
            // traverse right
            for (int i = colbegin; i <= colend; i++) {
                m[rowbegin][i] = s.nextInt();
            }
            rowbegin++;// op1

            // traversedown
            for (int i = rowbegin; i <= rowend; i++) {
                m[i][colend] = s.nextInt();
            }
            colend--;// op2

            if (rowbegin <= rowend) {
                // becoz row operation op1 has been done earlier need to check
                // traverse left
                for (int i = colend; i >= colbegin; i--) {
                    m[rowend][i] = s.nextInt();
                }
            }
            colbegin++;

            if (colbegin <= colend) {
                // becox previous operation on column op2, so check
                // traverse up
                for (int i = rowend; i <= rowbegin; i++) {
                    m[i][colbegin] = s.nextInt();
                }
                colbegin++;
            }
        } // end of while


        //output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

    }
}