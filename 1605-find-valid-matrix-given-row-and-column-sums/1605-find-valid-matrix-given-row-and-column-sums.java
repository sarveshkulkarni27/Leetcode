class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] finalGrid = new int[rowSum.length][colSum.length];
        
        for(int row = 0; row < finalGrid.length; row++){
            for(int column = 0; column < finalGrid[0].length; column++){
                finalGrid[row][column] = Math.min(rowSum[row], colSum[column]);
                rowSum[row] -= finalGrid[row][column];
                colSum[column] -= finalGrid[row][column];
            }
        }
        return finalGrid;
    }
}