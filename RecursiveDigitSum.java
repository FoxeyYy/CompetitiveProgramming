import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long superDigit(String n, int k) {

        long result = superDigit(n);

        result *= k;

        while (result > 9) {
            result = superDigit(String.valueOf(result));
        }

        return result;

    }

    static long superDigit(String n) {
        if (n.length() > 1) 
            return Character.getNumericValue(n.charAt(0)) 
                + superDigit(n.subSequence(1, n.length()).toString());

        return Long.valueOf(n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        long result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
