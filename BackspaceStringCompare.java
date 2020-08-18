class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        return edit(S).equals(edit(T));
        
    }
    
    private String edit(String str) {
        
        Deque<Character> edited = new LinkedList<>();
        
        for(char c: str.toCharArray()) {
            if (c == '#') edited.pollLast();
            else edited.add(c);
        }
        
        return String.valueOf(edited);
        
    }
}
