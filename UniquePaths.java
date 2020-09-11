class Solution {

    //Space: O(m*n)
    //Time: O(m*n)
    public int uniquePaths(int m, int n) {
        
        int[][] grid = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        
        return paths(grid, 0, 0);
        
    }
    
    private int paths(int[][] grid, int i, int j) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        if (i == m - 1 && j == n - 1) return 1; //Reached objective
        if (i == m || j == n) return 0; //Out of bounds
        if (grid[i][j] != -1) return grid[i][j]; //Memoized value
            
        int nextVal = paths(grid, i + 1, j) + paths(grid, i, j + 1);
        
        grid[i][j] = nextVal;
        
        return grid[i][j]; 
        
    }
    
    
}
