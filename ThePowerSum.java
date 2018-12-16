import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int powerSum(int X, int N, int current) {

        //O(XX^1/N) Time, O(1) Space
        if (X == 0) return 1; //Found a solution
        if (Math.pow(current, N) > X) return 0; //Current number is too large.

        return powerSum(X, N, current + 1) + // We can find a solution by skipping current number
            powerSum(X - (int)Math.pow(current, N), N, current + 1); //Or by using it

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N, 1);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
