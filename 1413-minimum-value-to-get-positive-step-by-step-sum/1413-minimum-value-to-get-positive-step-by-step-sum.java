class Solution {
    public int minStartValue(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int cumulativeSum = 0;
        for(int num : nums){
            cumulativeSum += num;
            minValue = Math.min(minValue, cumulativeSum);
        }
        if(minValue >= 1){
            return 1;
        }
        return Math.abs(minValue) + 1;
    }
}