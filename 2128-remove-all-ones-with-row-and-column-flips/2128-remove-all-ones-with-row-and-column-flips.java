class Solution {
    public boolean removeOnes(int[][] grid) {
        
        for(int row = 1; row < grid.length; row++){
            for(int column = 1; column < grid[0].length; column++){
                if((grid[row - 1][0] == grid[row][0]) != (grid[row - 1][column] == grid[row][column])){
                    return false;
                }
            }
        }
        
        return true;
    }
}