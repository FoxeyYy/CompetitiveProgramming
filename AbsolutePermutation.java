import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static void absolutePermutation(int n, int k) {

        if (k == 0) {
            for (int i = 1; i <=n; i++) {
                System.out.print(i + " ");
            }

            System.out.println();
            return;
        }

        if ((n/k) % 2 != 0 || n % k != 0) {
            System.out.println("-1");
            return;
        }



        for (int i = 1; i <= n; i += k*2) {
            for (int j = i; j < i + k*2; j++) {
                if ((j - i) < k) System.out.print(String.valueOf(j+k) + " ");
                else System.out.print(String.valueOf(j-k) + " ");
            }
        }

        System.out.println();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            absolutePermutation(n, k);

        }

        scanner.close();
    }
}

