class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> coordinateQueue = new LinkedList<int[]>();
        for(int row = 0; row < rooms.length; row++){
            for(int column = 0; column < rooms[0].length; column++){
                if(rooms[row][column] == 0){
                    coordinateQueue.add(new int[]{row, column});
                }
            }
        }
        
        getBFS(coordinateQueue, rooms);
    }
    
    public void getBFS(Queue<int[]> coordinateQueue, int[][] rooms){

        int[][] neighbors = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!coordinateQueue.isEmpty()){
            int[] currentCoordinate = coordinateQueue.poll();
            for(int[] neighbor : neighbors){
                int newRow = currentCoordinate[0] + neighbor[0];
                int newColumn = currentCoordinate[1] + neighbor[1];              
                if(newRow >= 0 && newRow < rooms.length && newColumn >= 0 && newColumn < rooms[0].length){
                    if(rooms[newRow][newColumn] == Integer.MAX_VALUE){
                        rooms[newRow][newColumn] = rooms[currentCoordinate[0]][currentCoordinate[1]] + 1;
                        coordinateQueue.add(new int[]{newRow, newColumn});
                    }                  
                }
            }
        }
        
    }
}