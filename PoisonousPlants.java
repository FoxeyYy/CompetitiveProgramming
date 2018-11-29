import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static class Plant {
        int pesticide;
        int daysAlive;

        public Plant (int pesticide, int daysAlive) {
            this.pesticide = pesticide;
            this.daysAlive = daysAlive;
        }
    }

    static int poisonousPlants(int[] p) {

        Stack<Plant> stack = new Stack<>();
        int maxDays = 0;

        for (Integer n: p) {
            int days = 0;

            while (!stack.isEmpty() && n <= stack.peek().pesticide) { // We search for previous plant that can't kill us
                days = Math.max(days, stack.pop().daysAlive); //  That plant days indicates how long we'll survive (Delete previous - it won't kill us)
            }

            if (stack.isEmpty()) { //As stack is empty, we know current plant won't be killed
                days = 0;
            } else { // Current plant will survive one day longer than previous max
                days++;
            }

            maxDays = Math.max(maxDays, days);

            stack.push(new Plant(n, days)); // We take previous plant maxDays
        }

        return maxDays;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
