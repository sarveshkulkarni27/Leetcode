class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int total = 1;
        for(int num : nums){
            if(num == 0 && zeroCount == 0){
                zeroCount++;
            }else if(num == 0 && zeroCount > 0){
                zeroCount++;
                break;
            }
            else{
                total *= num;
            }
        }
        if(zeroCount > 1){
            return new int[nums.length];
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] == 0){
                nums[index] = total;
            }else if(zeroCount == 1){
                nums[index] = 0;
            }else{
                nums[index] = total / nums[index];
            }
            
        }
        return nums;
    }
}