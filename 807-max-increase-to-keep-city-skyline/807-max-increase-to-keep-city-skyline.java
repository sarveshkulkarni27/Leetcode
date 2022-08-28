class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] column = new int[grid[0].length];
        
        int maxIncrease = 0;
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                
                row[r] = Math.max(row[r], grid[r][c]);
                column[c] = Math.max(column[c], grid[r][c]);
                
            }
        }
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                
                maxIncrease += Math.min(row[r], column[c]) - grid[r][c];
                
            }
        }
        return maxIncrease;
    }
}