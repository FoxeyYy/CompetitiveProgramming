import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, long c_lib, long c_road, int[][] cities) {
    
        //Iterative DFS to find how many nodes we have in a connected component
        //Carefully with nodes not connected to any or when building a library is cheaper.
        //O(n)

        if (c_lib < c_road) return n*c_lib;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] vertex: cities) {
            List<Integer> adjacentsA = graph.getOrDefault(vertex[0], new ArrayList<>());
            adjacentsA.add(vertex[1]);
            graph.put(vertex[0], adjacentsA);

            List<Integer> adjacentsB = graph.getOrDefault(vertex[1], new ArrayList<>());
            adjacentsB.add(vertex[0]);
            graph.put(vertex[1], adjacentsB);
        }

        long result = 0;
        Set<Integer> visited = new HashSet<>();

        for(int vertex: graph.keySet()) {
            if (visited.contains(vertex)) continue;

            Stack<Integer> DFS = new Stack<>();
            DFS.add(vertex);
            long numConnectedItems = 0;

            while(!DFS.isEmpty()) {
                vertex = DFS.pop();
                if (visited.contains(vertex)) continue;
                DFS.addAll(graph.get(vertex));
                visited.add(vertex);
                numConnectedItems++;
            }

            result += c_lib + (numConnectedItems - 1) * c_road;

        }

        return result + c_lib * (n- visited.size());

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            long c_lib = Long.parseLong(nmC_libC_road[2]);

            long c_road = Long.parseLong(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
