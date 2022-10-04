class Solution {
    public int minPathSum(int[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[row].length; column++){
                if(row == 0 && column == 0){
                    continue;
                }
                if(row == 0){
                    grid[row][column] += grid[row][column - 1];
                }
                if(column == 0){
                    grid[row][column] += grid[row - 1][column];
                }else if(row > 0 && column > 0) {
                    int top = grid[row - 1][column];
                    int left = grid[row][column - 1];
                    grid[row][column] += Math.min(top, left);                    
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}