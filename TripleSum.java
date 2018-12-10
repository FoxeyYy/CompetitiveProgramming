import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long triplets(int[] a, int[] b, int[] c) {
    
        //O(n) Time, travel each array once and order + remove duplicates, 
        //then the number of triplets is the number of A elements that are lower to current B one multiplied by
        // C elements lower to B.

        PriorityQueue<Integer> aHeap = new PriorityQueue<>(a.length, Collections.reverseOrder());
        PriorityQueue<Integer> bHeap = new PriorityQueue<>(b.length, Collections.reverseOrder());
        PriorityQueue<Integer> cHeap = new PriorityQueue<>(c.length, Collections.reverseOrder());

        Set<Integer> alrdyAdded = new HashSet<>();

        for(int num: a) {
            if (alrdyAdded.contains(num)) continue;
            aHeap.add(num);
            alrdyAdded.add(num);
        }

        alrdyAdded.clear();

        for(int num: b) {
            if (alrdyAdded.contains(num)) continue;
            bHeap.add(num);
            alrdyAdded.add(num);
        }

        alrdyAdded.clear();

        for(int num: c) {
            if (alrdyAdded.contains(num)) continue;
            cHeap.add(num);
            alrdyAdded.add(num);
        }

        long solutions = 0;

        while(!aHeap.isEmpty() && !bHeap.isEmpty() && !cHeap.isEmpty()) {
            int currentMax = bHeap.poll();

            while(!aHeap.isEmpty() && aHeap.peek() > currentMax) {
                int aNum = aHeap.poll();
            }

            while(!cHeap.isEmpty() && cHeap.peek() > currentMax) {
                int cNum = cHeap.poll();
            }

            solutions += aHeap.size()*(long)cHeap.size();
        }


        return solutions;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
