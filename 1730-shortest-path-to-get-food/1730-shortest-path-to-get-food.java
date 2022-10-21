class Solution {
    public int getFood(char[][] grid) {
        Queue<int[]> shortestPathQueue = new LinkedList<>();
        
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[row].length; column++){
                if(grid[row][column] == '*'){
                    shortestPathQueue.add(new int[]{row, column, 0});
                }
            }
        }
        
        int[][] neighbors = new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        while(!shortestPathQueue.isEmpty()){
            int[] currentPosition = shortestPathQueue.poll();
            int currentX = currentPosition[0];
            int currentY = currentPosition[1];
            for(int[] neighbor : neighbors){
                int newX = currentX + neighbor[0];
                int newY = currentY + neighbor[1];
                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[currentX].length){
                    if(grid[newX][newY] == '#'){
                        return currentPosition[2] + 1;
                    }else if(grid[newX][newY] == 'O'){
                        shortestPathQueue.add(new int[]{newX, newY, currentPosition[2] + 1});
                        grid[newX][newY] = '1';
                    }
                }
                
            }
        }
        return -1;
    }
}