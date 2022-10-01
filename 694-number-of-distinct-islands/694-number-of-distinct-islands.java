class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> distinctIslands = new HashSet<String>();
        
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[row].length; column++){
                if(grid[row][column] == 1){
                    StringBuilder sb = new StringBuilder();
                    getDFS(grid, row, column, sb, row, column);
                    distinctIslands.add(sb.toString());
                }
            }
        }
        return distinctIslands.size();
    }
    
    public void getDFS(int[][] grid, int originalRow, int originalColumn, StringBuilder sb, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == 0){
            return;
        }
        grid[row][column] = 0;
        sb.append((row - originalRow) + "," + (column - originalColumn) + ".");
        getDFS(grid, originalRow, originalColumn, sb, row + 1, column);
        getDFS(grid, originalRow, originalColumn, sb, row, column + 1);
        getDFS(grid, originalRow, originalColumn, sb, row - 1, column);
        getDFS(grid, originalRow, originalColumn, sb, row, column - 1);
    }
}