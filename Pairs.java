import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int pairs(int k, int[] arr) {

        //O(n) space and time. Build an index to speed up look ups for the neccesary number,
        // be careful for edge case when needed number is equal to current one.
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n: arr) {
            int occ = counts.getOrDefault(n, 0);
            counts.put(n, occ + 1);
        }

        int result = 0;

        for (int n: arr) {
            int occ = counts.getOrDefault(k+n, 0);
            counts.put(k+n, occ + 1);
            if (occ >= 1) result++;
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
