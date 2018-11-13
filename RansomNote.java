import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class RansomNote {

    /*
        Create a set with each of the words in the magazine.
        Then traverse every word in note, 
        if there's a single one that is not in the set we know
        that note cannot be built using the magazine
    */
    static void checkMagazine(String[] magazine, String[] note) {
        
        Map<String, Integer> bagOfWords = new HashMap<>(magazine.length);
        
        for (String word: magazine) {
            Integer num = bagOfWords.get(word);
            bagOfWords.put(word, num == null ? 1 : num+1);
        }
        
        for (String word: note) {
            Integer num = bagOfWords.get(word);
            if (num == null) {
                System.out.println("No");
                return;
            }
            
            num--;
            
            if (num < 1) {
                bagOfWords.remove(word);
            } else {
                bagOfWords.put(word, num);
            }
        }
        
        System.out.println("Yes");


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
