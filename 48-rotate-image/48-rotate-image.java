class Solution {
    public void rotate(int[][] matrix) {
        
        int maxInnerRotate = matrix.length / 2;
        int currentRotate = matrix.length - 1;
        
        for(int depth = 0; depth < maxInnerRotate; depth++){
            for(int index = depth; index <=  matrix.length - depth - 2; index++){
                int temp = matrix[index][matrix.length - depth - 1];
                matrix[index][matrix.length - depth - 1] = matrix[depth][index];
                                
                int temp1 = matrix[matrix.length - depth - 1][matrix.length  - 1 - index];
                matrix[matrix.length - depth - 1][matrix.length - 1 - index] = temp;
                
                
                temp = matrix[matrix.length - 1 - index][depth];
                matrix[matrix.length - 1 - index][depth] = temp1;
                                
                matrix[depth][index] = temp;
                
            }
        }
        
    }
}