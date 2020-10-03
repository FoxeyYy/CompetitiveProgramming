import java.io.*;
import java.util.*;

public class Solution {

    // 2019 Twilio OA assessment problem
    public static void main(String[] args) throws Exception {
        String[] prefixes = {"213", "21358", "1234", "12"};
        String[] phoneNumbers = {"21349049", "1204539492", "123490485904"};
        String[] desiredOutput = {"213", "12", "1234"};

        String[] output = findPrefixes(prefixes, phoneNumbers);

        if (!Arrays.equals(output, desiredOutput)) throw new Exception("Wrong result!");

        System.out.println("OK");

    }

    //Time: O(n*avg) where n is phoneNumbers.length & avg is phoneNumbers average size
    //Space: O(m) where m is prefixes.length
    public static String[] findPrefixes(String[] prefixes, String[] phoneNumbers) {

        String[] sol = new String[phoneNumbers.length];

        Trie trie = new Solution.Trie();

        for(String prefix: prefixes) trie.insert(prefix);

        for(int i = 0; i < phoneNumbers.length; i++) {
            String number = phoneNumbers[i];
            sol[i] = trie.findLongestPrefix(number);
        }

        return sol;

    }

    private static class Trie {

        private static class Node {
            private static final int DIC_SIZE = 10;

            public char value;
            public Node[] children = new Node[DIC_SIZE];

            public boolean isWord = false;

            public Node(char value) {
                this.value = value;
            }
        }

        private final Trie.Node root;

        public Trie() {
            this.root = new Node('*');
        }

        public void insert(String word) {

            Trie.Node current = root;

            for(Character letter: word.toCharArray()) {
                if(current.children[letter - '0'] == null) current.children[letter - '0'] = new Node(letter);

                current = current.children[letter - '0'];
            }

            current.isWord = true;

        }

        public String findLongestPrefix(String word) {

            Trie.Node current = root;
            StringBuilder builder = new StringBuilder();

            for(Character letter: word.toCharArray()) {
                Trie.Node next = current.children[letter - '0'];

                if (next == null) break;

                builder.append(letter);

                current = next;
            }

            return builder.toString();

        }

    }

}
