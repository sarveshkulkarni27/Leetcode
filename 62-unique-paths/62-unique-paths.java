class Solution {

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for(int row = 1; row < matrix.length; row++){
            for(int column = 1; column < matrix[0].length; column++){
                if(row - 1 == 0 && column - 1 == 0){
                    matrix[row][column] = 2;
                }                 
                else if(row - 1 == 0){
                    matrix[row][column] = 1 + matrix[row][column - 1];
                }else if(column - 1 == 0){
                    matrix[row][column] = 1 + matrix[row - 1][column];
                }     
                else{
                    matrix[row][column] = matrix[row - 1][column] + matrix[row][column - 1];
                }
                
            }
        }
        return matrix[m - 1][n - 1];
    }
    
}