import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class SherlockAndAnagrams {

    /*
      Travel each subset of words and sort them, 
      then sum 1 to currentValue -or 1 if empty- and replace in map.
      
      Then for each key the number of anagrams is count/2.
    */
    static int sherlockAndAnagrams(String s) {
        
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            while (len + i <= s.length()) {
                char[] sub = s.substring(i, i+len).toCharArray();
                Arrays.sort(sub);
                String sortedSub = String.valueOf(sub);
                Integer count = counts.get(sortedSub);
                count = count == null ? 1 : ++count;
                counts.put(sortedSub, count);
                len++;
            }
        }
        
        int sum = 0;
        
        for(String key: counts.keySet()) {
            int count = counts.get(key);
            sum += count*(count-1)/2;
        }
        
        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
