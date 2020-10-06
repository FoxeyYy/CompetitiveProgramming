import java.util.*;

public class Solution {

    //Twilio 2020 OA problem
    //Source: https://leetcode.com/discuss/interview-question/609179/Twilio-OA-2020
    public static void main(String[] args) throws Exception {

        String[] vanityCodes = {
                "TWLO",
                "CODE",
                "HTCH"
        };

        String[] phoneNumbers = {
                "+17474824380",
                "+14157088956",
                "+919810155555",
                "+15109926333",
                "+1415123456",
        };

        String[] desiredOutput = {
                "+17474824380",
                "+14157088956",
                "+15109926333",

        };

        String[] output = findCodes(vanityCodes, phoneNumbers);

        if (!Arrays.equals(output, desiredOutput)) throw new Exception("Wrong result!");

        System.out.println("OK");

    }

    private static final Map<Character, Character> charToNumb = new HashMap<>();

    private static void fillMap() {
        charToNumb.clear();

        charToNumb.put('A', '2');
        charToNumb.put('B', '2');
        charToNumb.put('C', '2');
        charToNumb.put('D', '3');
        charToNumb.put('E', '3');
        charToNumb.put('F', '3');
        charToNumb.put('G', '4');
        charToNumb.put('H', '4');
        charToNumb.put('I', '4');
        charToNumb.put('J', '5');
        charToNumb.put('K', '5');
        charToNumb.put('L', '5');
        charToNumb.put('M', '6');
        charToNumb.put('N', '6');
        charToNumb.put('O', '6');
        charToNumb.put('P', '7');
        charToNumb.put('Q', '7');
        charToNumb.put('R', '7');
        charToNumb.put('S', '7');
        charToNumb.put('T', '8');
        charToNumb.put('U', '8');
        charToNumb.put('V', '8');
        charToNumb.put('W', '9');
        charToNumb.put('X', '9');
        charToNumb.put('Y', '9');
        charToNumb.put('Z', '9');
    }

    private static String convertCodeToNums(String code) {

        StringBuilder sol = new StringBuilder();

        for(char l: code.toCharArray()) {
            sol.append(charToNumb.get(l));
        }

        return sol.toString();

    }

    //Time: O(k*i*n) where k is vanityCodes length & i is average length of each phone number & n is number of phone numbers
    //Space: O(k + m) where k is vanityCodes length & m is average length of each vanity code
    public static String[] findCodes(String[] vanityCodes, String[] phoneNumbers) {

        fillMap();

        //Convert vanity codes.
        String[] convertedCodes = Arrays.stream(vanityCodes)
                .map(Solution::convertCodeToNums)
                .toArray(String[]::new);

        List<String> matches = new LinkedList<>();

        for(String number: phoneNumbers) {
            for(String code: convertedCodes) {
                if (StringContains(code, number)) {
                    matches.add(number);
                }
            }
        }

        return matches.toArray(new String[0]);

    }

    private static boolean StringContains(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int[] lps = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                return true;
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        return false;
    }

    private static void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
