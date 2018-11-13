import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {

    /*
        For every char in s1, create a set with each char.
        Now traverse s2 chars, if any of them exists in the set there is a substring, false otherwise.
    */
    static String twoStrings(String s1, String s2) {
        
        Set<Character> bagOfCharacters = new HashSet<>();
        
        for (char c: s1.toCharArray()) {
            bagOfCharacters.add(c);
        }
        
        for (char c: s2.toCharArray()) {
            if(bagOfCharacters.contains(c)) {
                return "YES";
            }
        }
        
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
