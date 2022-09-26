class Solution {
    int maxAreaOfIsland = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 1){
                    maxAreaOfIsland = Math.max(maxAreaOfIsland, getDFS(grid, row, column));
                }
            }
        }
        return maxAreaOfIsland;
    }
    
    public int getDFS(int[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0){
            return 0;
        }
        grid[row][column] = 0;
        return 1 + getDFS(grid, row + 1, column) + getDFS(grid, row - 1, column) + getDFS(grid, row, column + 1) + getDFS(grid, row, column - 1);
}
}