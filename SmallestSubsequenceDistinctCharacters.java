class Solution {
    
    private static int ALPH_SIZE = 26;
    
    //Time: O(n) where n is string size
    //Space: O(1)
    public String removeDuplicateLetters(String s) {
        
        int[] lastIndexes = buildLastIndexArray(s);
        
        Stack<Character> stack = new Stack();
        Set<Character> alreadyUsed = new HashSet<>();
        char[] charArray = s.toCharArray();
        
        for(int i = 0; i < charArray.length; i++) {
            
            char c = charArray[i];
            if (alreadyUsed.contains(c)) continue;
            
            while(!stack.isEmpty() && c < stack.peek() && lastIndexes[stack.peek() - 'a'] > i) { 
                char removed = stack.pop();
                alreadyUsed.remove(removed);
            }
            
            stack.push(c);
            alreadyUsed.add(c);
            
        }
        
        return stackToString(stack);
    }
    
    private int[] buildLastIndexArray(String s) {
        int[] indexes = new int[ALPH_SIZE];
        
        for(int i = 0; i < s.length(); i++) {
            indexes[s.charAt(i) - 'a'] = i;
        }
        
        return indexes;
    }
    
    private String stackToString(Stack<Character> stack) {
        
        StringBuilder builder = new StringBuilder();
        
        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        
        return builder.reverse().toString();
        
    }
}
