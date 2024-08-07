import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;

public class i {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String arr[] = s.split("\\s");
        int k = sc.nextInt();


        HashMap<String, Integer> ch = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String x = arr[i];
            int c = ch.getOrDefault(x, 0) + 1;
            ch.put(x, c);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(ch.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                int cmp = e2.getValue().compareTo(e1.getValue());
                if (cmp == 0)
                    return e1.getKey().compareTo(e2.getKey());
                else
                    return cmp;
            }
        });
        int count = 0;

        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + " "+e.getValue());
            count++;
            if (count == k)
                break;
        }
    }
}