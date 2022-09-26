class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> coordinatesList = new ArrayList<>();
        for(int row = 0; row < heights.length; row++){
            for(int column = 0; column < heights[row].length; column++){
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                List<Integer> currentCoordinates = new ArrayList<Integer>();
                if(heights.length == 1 || heights[0].length == 1 || (row == 0 && column == heights[0].length - 1) || 
                  (row == heights.length - 1 && column == 0)){
                    currentCoordinates.add(row);
                    currentCoordinates.add(column);
                    coordinatesList.add(currentCoordinates);
                }else{
                    Set<Integer> oceanSet = new HashSet<Integer>();
                    getDFS(heights, row, column, oceanSet, visited);
                    if(oceanSet.size() == 2){
                        currentCoordinates.add(row);
                        currentCoordinates.add(column);
                        coordinatesList.add(currentCoordinates);                        
                    }
                }               
            }
        }
        return coordinatesList;
    }
    
    public void getDFS(int[][] heights, int row, int column, Set<Integer> oceanSet, boolean[][] visited){
        if(row < 0 || row >= heights.length || column < 0 || column >= heights[0].length || oceanSet.size() == 2 || visited[row][column]){
            return;
        }
        visited[row][column] = true;
        if((row == 0 && column == heights[0].length - 1) || (column == 0 && row == heights.length - 1)){
            oceanSet.add(0);
            oceanSet.add(1);
            return;
        }else if(row == 0 || column == 0){
            oceanSet.add(0);
        }else if(row == heights.length - 1 || column == heights[0].length - 1){
            oceanSet.add(1);
        }
        if(row + 1 >= 0 && row + 1 < heights.length && heights[row + 1][column] <= heights[row][column]){
            getDFS(heights, row + 1, column, oceanSet, visited);
        }
        if(row - 1 >= 0 && row - 1 < heights.length && heights[row - 1][column] <= heights[row][column]){
            getDFS(heights, row - 1, column, oceanSet, visited);
        }
        if(column + 1 >= 0 && column + 1 < heights[0].length && heights[row][column + 1] <= heights[row][column]){
            getDFS(heights, row, column + 1, oceanSet, visited);
        }
        if(column - 1 >= 0 && column - 1 < heights[0].length && heights[row][column - 1] <= heights[row][column]){
            getDFS(heights, row, column - 1, oceanSet, visited);
        }        
    }
}