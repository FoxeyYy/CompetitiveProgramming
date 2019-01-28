import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the redJohn function below.
    static int redJohn(int n) {

        int m = numWays(n, new HashMap<>());
        return primes(m);

    }

    static int numWays(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 4) return 2;
        if (n < 4) return 1;

        int result = numWays(n - 1, memo) + numWays(n - 4, memo);

        memo.put(n, result);

        return result;
    }

    static int primes(int m) {
        int num = 0;

        for(int i = 0; i <= m; i++) {
            if (isPrime(i)) num++;
        }

        return num;
    }

    static boolean isPrime(int n) {

        if (n < 2) return false;
 

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = redJohn(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
