import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String organizingContainers(int[][] container) {

        int[] numBalls = new int[container[0].length];
        Map<Integer, Integer> containerSizes = new HashMap<>();

        //O(rows*cols) Time, O(Max(rows, cols)) Space
        for (int row = 0; row < container.length; row++) {
            int containerSize = 0;
            for (int col = 0; col < container[row].length; col++) {
                numBalls[col] += container[row][col];
                containerSize += container[row][col];
            }
            int numContainers = containerSizes.getOrDefault(containerSize, 0);
            numContainers++;
            containerSizes.put(containerSize, numContainers);
        }

        for (int count: numBalls) {
            int numContainers = containerSizes.getOrDefault(count, 0);
            numContainers--;
            containerSizes.put(count, numContainers);
        }

        for(int remaining: containerSizes.values()) {
            if (remaining != 0) return "Impossible";
        }

        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
