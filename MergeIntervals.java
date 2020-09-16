class Solution {
    
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
          return Integer.compare(a[0], b[0]);
        }
    }

    //Time complexity: (O(nlogn)) where n is intervals size
    //Space complexity: (O(n)) where n is intervals size
    public int[][] merge(int[][] intervals) {

        Arrays.sort(
            intervals, 
            new IntervalComparator()
        );

        LinkedList<int[]> sol = new LinkedList<>();
        int[] lastInterval = null;
        
        for (int[] interval : intervals) {
            if (sol.isEmpty() || lastInterval[1] < interval[0]) {
                sol.add(interval);
            } else {
                sol.getLast()[1] = Math.max(lastInterval[1], interval[1]);
            }
            
            lastInterval = sol.getLast();
        }

        return sol.toArray(new int[0][0]);
    }
    
}
