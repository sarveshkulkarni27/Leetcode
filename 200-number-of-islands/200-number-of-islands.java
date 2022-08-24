class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == '1'){
                    getNumberOfIslands(grid, row, column);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }
    
    public void getNumberOfIslands(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0'){
            return;
        }
        grid[row][column] = '0';
        getNumberOfIslands(grid, row + 1, column);
        getNumberOfIslands(grid, row - 1, column);
        getNumberOfIslands(grid, row, column + 1);
        getNumberOfIslands(grid, row, column - 1);
    }
}