class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] mins = new int[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++) {
            Arrays.fill(mins[i], Integer.MAX_VALUE);
        }
        
        return minPathSum(grid, 0, 0, mins);
    }
    
    // Space: O(rows*cols)
    // Time: O(rows*cols)
    private int minPathSum(int[][] grid, int row, int col, int[][] mins){
    
        if (row == grid.length -1 && col == grid[row].length - 1) return grid[row][col];
        if (row >= grid.length || col >= grid[row].length) return Integer.MAX_VALUE;
        if (mins[row][col] != Integer.MAX_VALUE) return mins[row][col];

        int min = Math.min(
            minPathSum(grid, row + 1, col, mins),
            minPathSum(grid, row, col + 1, mins)    
        );
        
        min += grid[row][col];

        mins[row][col] = min;

        return min;
    }
}
