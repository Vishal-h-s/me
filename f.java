import java.util.Scanner;

class f {
    public static int water(int[] arr, int n) {
        int res = 0;

        for (int i = 1; i < n; i++) {
            int left = 0;
            for (int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);

            int right = 0;
            for (int j = i + 1; j < n; j++)
                right = Math.max(arr[j], right);

            int level = Math.min(left, right);

            if (level > arr[i])
                res += (level - arr[i]);
        }

        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of bars: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Heights");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(water(arr, n));
    }
}