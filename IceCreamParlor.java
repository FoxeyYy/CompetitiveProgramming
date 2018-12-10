import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void whatFlavors(int[] cost, int money) {

        //Build an index, then use it to speed up the look up. O(n) space and time
        Map<Integer, Integer> flavors = new HashMap<>();
        
        for(int i = 0; i < cost.length; i++) {
            flavors.put(cost[i], i);
        }

        for(int i = 0; i < cost.length; i++) {
            if (cost[i] > money) continue;

            Integer index = flavors.get(money - cost[i]);

            if (index != null && index != i) {
                System.out.print(Math.min(index, i) + 1);
                System.out.print(" ");
                System.out.println(Math.max(index, i) + 1);
                return;
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
