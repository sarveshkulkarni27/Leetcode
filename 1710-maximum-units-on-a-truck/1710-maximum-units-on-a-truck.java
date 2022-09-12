class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int quantity = 0;
        for(int[] boxUnits : boxTypes){
            if(boxUnits[0] < truckSize){
                quantity += boxUnits[0] * boxUnits[1];
            }else{
                quantity += truckSize * boxUnits[1];
                break;
            }
            truckSize -= boxUnits[0];
        }
        return quantity;
    }
}