import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stoneDivision function below.
    static long stoneDivision(long n, long[] s, Map<Long, Long> memo) {

        if (memo.containsKey(n)) return memo.get(n);

        long result = 0;

        for(long num: s) {
            if (n == num || n%num != 0) continue; //We cant divide given those conditions

            result = Math.max(result, 1 + (n/num)*stoneDivision(num, s, memo)); //For each new Stack we can try to divide its new length
        }

        memo.put(n, result);

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            long n = Long.parseLong(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] s = new long[m];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long sItem = Long.parseLong(sItems[i]);
                s[i] = sItem;
            }

            long result = stoneDivision(n, s, new HashMap<>());

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
