import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String biggerIsGreater(String w) {

        //O(n) Time, O(1) Space

        int i, j;
        
        i = j = w.length() - 1;

        while (i > 0 && w.charAt(i-1) >= w.charAt(i)) {
            i--;
        }

        if (i <= 0) return "no answer";
        
        while (w.charAt(j) <= w.charAt(i-1)) 
            j--;

        char[] result = w.toCharArray();

        char tmp = result[i-1];
        result[i-1] = result[j];
        result[j] = tmp;

        j = w.length() - 1;

        while (i <= j) {
            tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
            i++;
            j--;
        }

        return String.valueOf(result);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
