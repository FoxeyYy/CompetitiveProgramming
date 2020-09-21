class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> sol = new LinkedList<>();
        
        generateParenthesis(0, 0, sol, "", n);
        
        return sol;
        
    }
    
    private void generateParenthesis(int open, int closes, List<String> sol, String curr, int obj) {
        
        if (closes > open) return;
        if (open > obj) return;
        
        if (open == obj && closes == obj) {
            sol.add(curr);
            return;
        }
        
        generateParenthesis(open + 1, closes, sol, curr + "(", obj);
        generateParenthesis(open, closes + 1, sol, curr + ")", obj);
        
    }
    
}
