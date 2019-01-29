import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long stockmax(int[] prices) {

        long profit = 0L;

        int max = Integer.MIN_VALUE;

        //O(n) time, O(1) Space
        for (int i = prices.length - 1; i > -1 ; i--) {

            max = Math.max(max, prices[i]);
            profit += max - prices[i];

        }

        return profit;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] pricesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] prices = new int[pricesItems.length];

            for (int i = 0; i < pricesItems.length; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            long result = stockmax(prices);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
