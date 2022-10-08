class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> dijkstra = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        dijkstra.add(new int[]{0, 0, 0});
        int[][] distance = new int[heights.length][heights[0].length];
        for(int row = 0; row < heights.length; row++){
            for(int column = 0; column < heights[row].length; column++){
                distance[row][column] = Integer.MAX_VALUE;
            }
        }

        
        int[][] neighbors = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int returnVal = Integer.MAX_VALUE;
        while(!dijkstra.isEmpty()){
            int[] currentNode = dijkstra.poll();             
            for(int[] neighbor : neighbors){
                int newX = currentNode[0] + neighbor[0];
                int newY = currentNode[1] + neighbor[1];
                if(newX == 0 && newY == 0){
                    continue;
                }
                if(newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length){
                    int absoluteDifference = Math.abs(heights[currentNode[0]][currentNode[1]] - heights[newX][newY]);
                    int val = Math.max(absoluteDifference, currentNode[2]);
                    if(val < distance[newX][newY]){
                        distance[newX][newY] = val;
                        dijkstra.add(new int[]{newX, newY, val});
                        if(newX == heights.length - 1 && newY == heights[0].length - 1){
                            returnVal = val;
                            break;
                        }                        
                    }
                    
                }
            }             
        }
        return returnVal == Integer.MAX_VALUE ? 0 : returnVal;
    }
}