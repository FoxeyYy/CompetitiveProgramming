class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid.length == 0) return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(visited[i][j] || grid[i][j] == '0') continue;
                
                islands++;
                visitNeighbours(grid, visited, i, j);
            }
        }
        
        return islands;
        
    }
    
    private void visitNeighbours(char[][] grid, boolean[][] visited, int i, int j) {
        
        Queue<int[]> toVisit = new LinkedList<>();
        
        toVisit.add(new int[]{i, j});
        
        while(!toVisit.isEmpty()) {
            
            int[] pos = toVisit.poll();
            int row = pos[0];
            int col = pos[1];
            
            if(row == -1 || col == -1) continue;
            if(row == grid.length || col == grid[i].length) continue;
            if(visited[row][col] || grid[row][col] == '0') continue;
            
            visited[row][col] = true;
            
            toVisit.add(new int[]{row + 1, col});
            toVisit.add(new int[]{row - 1, col});
            toVisit.add(new int[]{row, col + 1});
            toVisit.add(new int[]{row, col - 1});
            
        }
        
    }
}
