import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {

        List<Integer> origins = new LinkedList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < graphFrom.length; i++) {
            int from = graphFrom[i];
            int to = graphTo[i];

            List<Integer> adjacency = graph.getOrDefault(from, new LinkedList<>());
            adjacency.add(to);
            graph.put(from, adjacency);

            adjacency = graph.getOrDefault(to, new LinkedList<>());
            adjacency.add(from);
            graph.put(to, adjacency);
        }

        // Color for each node
        for (int i = 0; i<ids.length; i++) {
            if(ids[i] == val) origins.add(i+1);
        }

        //BFS to find closest one with our color, we stop as soon as we find one.
        if (origins.isEmpty()) return -1;

        int min = -1;

        for (int node: origins) {

            Set<Integer> visited = new HashSet<>();
            Queue<Integer> toVisit = new LinkedList<>();
            toVisit.add(node);
            int pathLength = 0;

            while(!toVisit.isEmpty()){
                node = toVisit.poll();
                if (visited.contains(node)) continue;
                visited.add(node);
                List<Integer> neighbours = graph.get(node);
                if(neighbours != null) toVisit.addAll(neighbours);

                if (ids[node-1] == val && pathLength > 0) {
                    min = min == -1 ? pathLength : Math.min(min, pathLength);
                    break;
                }

                pathLength++;
            }

        }


        return min;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        System.out.println(ans);

        scanner.close();
    }
}
