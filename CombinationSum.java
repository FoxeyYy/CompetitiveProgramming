class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        List<List<List<Integer>>> sols = new ArrayList<>();
        
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> sol = new ArrayList<>();

            for(int candidate: candidates) {
                
                int rem = i - candidate;
                
                if (rem < 0) break;
                if (rem == 0) {
                    sol.add(Arrays.asList(candidate));
                    continue;
                }
                
                for (List<Integer> path : sols.get(rem - 1)) {
                    if (candidate > path.get(0)) continue;
                    List<Integer> newPath = new ArrayList<>();
                    newPath.add(candidate);
                    newPath.addAll(path);
                    sol.add(newPath);
                }
            }
            sols.add(sol);
        }
        
        return sols.get(target - 1);

    }
}
