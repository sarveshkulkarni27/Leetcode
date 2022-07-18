class Solution {
    int[][] directionArray = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public void gameOfLife(int[][] board) {
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                // System.out.println(row + " " + column);
                getNeighbors(board, row, column);
            }
        }
        
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                if(board[row][column] == 1 || board[row][column] == 2){
                    board[row][column] = 1;
                }else{
                    board[row][column] = 0;
                }
            }
        }        
    }
    
    public void getNeighbors(int[][] board, int row, int column){
        int count = 0;
        for(int[] direction : directionArray){
            // System.out.println(direction[0] + " " + direction[1] + " " + row + " " + column);
            int neighborRow = row + direction[0];
            int neighborColumn = column + direction[1];
            // System.out.println("Neighbor Row" + neighborRow + " Neighbor Column" + neighborColumn);
            if(neighborRow >= 0 && neighborRow < board.length &&
              neighborColumn >= 0 && neighborColumn < board[0].length
              && (board[neighborRow][neighborColumn] == 1 || board[neighborRow][neighborColumn] == -1)){
                count++;
            }
        }
        
        if(board[row][column] == 1){
            if(count == 2 || count == 3){
                board[row][column] = 1;
            }else{
                board[row][column] = -1;
            }
            
         }else{
            if(count == 3){
                board[row][column] = 2;
            }else{
                 board[row][column] = 0;
            }
           
        }
//         else{
//             board[row][column] = -1;
//           }
        
    }
}