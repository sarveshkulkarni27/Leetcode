class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] newNums = new int[nums.length - 1];
        
        while(true){
            for(int index = 0; index < nums.length - 1; index++){
                newNums[index] = nums[index] + nums[index + 1];
                if(newNums[index] >= 10){
                    newNums[index] = newNums[index] % 10;
                }                
            }
            nums = newNums;
            if(nums.length == 1){
                break;
            }
            newNums = new int[nums.length - 1];
        }
        return nums[0];
    }
}