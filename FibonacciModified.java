import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static BigInteger fibonacciModified(int t1, int t2, int n) {

        BigInteger[] memo = new BigInteger[n];

        memo[0] = new BigInteger(String.valueOf(t1));
        memo[1] = new BigInteger(String.valueOf(t2));

        //O(n) space and time
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i-1].multiply(memo[i-1]).add(memo[i-2]);
        }
        return memo[n - 1];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(result.toString());
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
