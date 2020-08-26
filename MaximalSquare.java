class Solution {
    public int maximalSquare(char[][] matrix) {
        
        /*
        [
        1 0 1 0 0
        1 0 1 1 1
        1 1 1 2 2
        1 0 1 2 3
        ]
        */        
        if (matrix.length == 0) return 0;
        
        int maxSquare = 0;

        int[][] maxSoFar = new int[matrix.length][matrix[0].length];
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0 || col == 0) {
                    maxSoFar[row][col] = Integer.parseInt(String.valueOf(matrix[row][col]));
                                    maxSquare = Math.max(maxSquare, maxSoFar[row][col] * maxSoFar[row][col]);
                    continue;
                }
                
                if (matrix[row][col] == '1') {
                    maxSoFar[row][col] = 1 + Math.min(
                        maxSoFar[row-1][col-1],
                        Math.min(
                            maxSoFar[row-1][col],
                            maxSoFar[row][col-1]
                        )
                    );
                }
                
                maxSquare = Math.max(maxSquare, maxSoFar[row][col] * maxSoFar[row][col]);
            }
        }
        
        return maxSquare;
        
    }
}
