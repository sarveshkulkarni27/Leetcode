class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxVal = Integer.MIN_VALUE;        
        int maxChunks = 1;
        
        for(int index = 0; index < arr.length - 1; index++){
            maxVal = Math.max(maxVal, arr[index]);
            if(maxVal <= index){
                maxChunks++;
            }
        }
        return maxChunks;
    }
}