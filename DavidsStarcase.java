import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //Bottom-up O(n) space and time
    static int stepPerms(int n) {

        int[] memo = new int[n+1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) memo[0] = 0;
            else if (i == 1) memo[1] = 1;
            else if (i == 2) memo[2] = 2;
            else if (i == 3) memo[3] = 4;
            else memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }

        return memo[n];
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
