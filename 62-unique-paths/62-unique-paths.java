class Solution {

    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1){
            return 1;
        }
        int[][] matrix = new int[m + 1][n + 1];
        for(int row = 1; row < matrix.length; row++){
            for(int column = 1; column < matrix[0].length; column++){
                if((row == 1 && column == 2) || (row == 2 && column == 1)){
                    matrix[row][column] = 1;
                }else{
                    matrix[row][column] = matrix[row - 1][column] + matrix[row][column - 1];
                }
                
            }
        }
        return matrix[m][n];
    }
    
}