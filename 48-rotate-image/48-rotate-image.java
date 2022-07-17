class Solution {
    public void rotate(int[][] matrix) {
//         int row = 0;
//         int column = matrix.length - 1 - row;
//         int difference = column - row;
        
//         while(true){
//             for(int index = 0; index < difference; index++){
//                 int temp = matrix[row][difference];
                
//             }
//         }
        
        
        
        int maxInnerRotate = matrix.length / 2;
        int currentRotate = matrix.length - 1;
        
        for(int depth = 0; depth < maxInnerRotate; depth++){
            // int currentLocation = matrix[depth][depth];
            System.out.println("In");
            for(int index = depth; index <=  matrix.length - depth - 2; index++){
                // System.out.println(depth + " " + index);
                int temp = matrix[index][matrix.length - depth - 1];
                matrix[index][matrix.length - depth - 1] = matrix[depth][index];
                
                // System.out.println(matrix[index][matrix.length - depth - 1]);
                
                int temp1 = matrix[matrix.length - depth - 1][matrix.length  - 1 - index];
                matrix[matrix.length - depth - 1][matrix.length - 1 - index] = temp;
                
                // System.out.println(matrix[matrix.length - depth - 1][matrix.length - depth - 1 - index]);
                
                temp = matrix[matrix.length - 1 - index][depth];
                matrix[matrix.length - 1 - index][depth] = temp1;
                
                // System.out.println(matrix[matrix.length - depth - 1][index]);
                
                matrix[depth][index] = temp;
                
                // System.out.println(matrix[depth][index]);
                
                // System.out.println(matrix[depth][index] + " " + matrix[index][matrix.length - depth - 1] + " " + matrix[matrix.length - depth - 1][index] + " " + matrix[index][matrix.length - depth - 1] );
            }
        }
        
        // return matrix;
    }
}