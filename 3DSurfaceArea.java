import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // O(HW) Time, O(1) Space
    static long surfaceArea(int[][] A) {

        long area = 2*(A.length-2)*(A[0].length-2);

        for (int row = 1; row < A.length - 1; row++) {
            for (int col = 1; col < A[row].length - 1; col++){
                area += Math.max(0, A[row][col] - A[row+1][col]);
                area += Math.max(0, A[row][col] - A[row-1][col]);
                area += Math.max(0, A[row][col] - A[row][col+1]);
                area += Math.max(0, A[row][col] - A[row][col-1]);
            }
        }

        return area;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H+2][W+2];

        for(int[] row: A) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i+1][j+1] = AItem;
            }
        }

        long result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
