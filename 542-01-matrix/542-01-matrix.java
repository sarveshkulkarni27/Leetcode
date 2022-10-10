class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] finalAnswer = new int[mat.length][mat[0].length];
        for(int[] row : finalAnswer){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int row = 0; row < mat.length; row++){
            for(int column = 0; column < mat[row].length; column++){
                if(mat[row][column] == 0){
                    queue.add(new int[]{row, column});
                    finalAnswer[row][column] = 0;
                }
            }
        }
        
        int[][] neighbors = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()){
            int[] currentCell = queue.poll();
            
            for(int[] neighbor : neighbors){
                int newX = currentCell[0] + neighbor[0];
                int newY = currentCell[1] + neighbor[1];
                if(newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[currentCell[0]].length){
                    if(finalAnswer[newX][newY] > finalAnswer[currentCell[0]][currentCell[1]] + 1){
                        finalAnswer[newX][newY] = finalAnswer[currentCell[0]][currentCell[1]] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                    
                }

            }
        }        
        return finalAnswer;
    }
}