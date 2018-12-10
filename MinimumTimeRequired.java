import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int goal = sc.nextInt();
        int[] machines = new int[n];
        for (int i = 0; i < machines.length; i++) {
            machines[i] = sc.nextInt();
        }
        System.out.println(solve(machines, goal));

        sc.close();
    }

    static long solve(int[] machines, int goal) {
    
        // User a modified binary search to find required day
        long result = 0;
        long lower = 1;
        long upper = 1000000000000000000L;

        while (lower <= upper) {
            long mid = (lower + upper) / 2;

            int totalProd = getProduction(machines, mid);

            if (totalProd >= goal) {
                result = mid;
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return result;
    }

    static int getProduction(int[] machines, long days) {
        long itemNumber = 0;
        for (int machine : machines) {
            itemNumber += days / machine;

            if (itemNumber > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) itemNumber;
    }
}
