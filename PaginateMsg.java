import java.util.*;

public class Solution {

    //Twilio 2019 OA problem
    //Source: https://leetcode.com/discuss/interview-question/394697/Twilio-or-OA-2019
    public static void main(String[] args) throws Exception {
        String input = "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg";
        String[] desiredOutput = {
                "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds (1/3)",
                "lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk (2/3)",
                "lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg(3/3)"
        };
        String[] output = split(input);

        if (!Arrays.equals(output, desiredOutput)) throw new Exception("Wrong result!");

        System.out.println("OK");

    }

    static final int PAGINATION_SIZE = 160;
    static final int INDICATOR_SIZE = "(1/5)".length();

    //Time: O(n) where n is input length
    //Space: O(k) where k is number of paginations
    public static String[] split(String input) {

        List<String> splits = new LinkedList<>();
        int start = 0, end = start + PAGINATION_SIZE - INDICATOR_SIZE;

        while(start < input.length()) {

            while(
                    end >= input.length() ||
                            (end != input.length() - 1 && input.charAt(end) != ' ' && input.charAt(end + 1) != ' ')
            ) { //Assuming we can always split
                end--;
            }

            splits.add(input.substring(start, end + 1));
            start = end + 1;
            end = start + PAGINATION_SIZE - INDICATOR_SIZE;

        }

        //Phase 2: Append pagination indicators
        List<String> sol = new LinkedList<>();

        int idx = 1;
        for(String split: splits) {
            sol.add(split + "(" + idx + "/" + splits.size() + ")");
            idx++;
        }

        return sol.toArray(new String[0]);

    }

}
