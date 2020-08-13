class Solution {

    public int longestStrChain(String[] words) {
        
        List<List<Integer>> paths = buildGraph(words);
        
        int[] scores = new int[words.length];
        int maximumLength = 0;
        
        for(int i = 0; i < words.length; i++) {
            maximumLength = Math.max(maximumLength, longest(i, scores, paths));
        }
        
        return maximumLength;
        
    }
    
    private List<List<Integer>> buildGraph(String[] words) {
        List<List<Integer>> paths = new ArrayList<>(words.length);
        Map<String, Integer> wordIdx = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            paths.add(new LinkedList<>());
            wordIdx.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                String possible = word.substring(0, j) + word.substring(j + 1);
                
                if (!wordIdx.containsKey(possible)) continue;
                
                int possibleIdx = wordIdx.get(possible);
                
                List<Integer> possiblePaths = paths.get(possibleIdx);
                possiblePaths.add(i);
                paths.set(possibleIdx, possiblePaths);
            }
        }
        
        return paths;
    }
    
    private int longest(int v, int[] scores, List<List<Integer>> paths) {
        if (scores[v] > 0) return scores[v];
        
        int longestPath = 1;
        
        for(Integer child: paths.get(v)) {
            longestPath = Math.max(longestPath, longest(child, scores, paths) + 1);
        }
        
        scores[v] = longestPath;
        
        return longestPath;
    }
    
}
