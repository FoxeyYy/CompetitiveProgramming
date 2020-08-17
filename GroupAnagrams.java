class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                
        Map<String, List<String>> bySortedValue = new HashMap<>();
        
        for(String str: strs) {
            
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            
            List<String> group = bySortedValue.getOrDefault(sortedString, new LinkedList<String>());
            group.add(str);
            bySortedValue.put(sortedString, group);
            
        }
        
        
        return new LinkedList<>(bySortedValue.values());
        
    }
}
