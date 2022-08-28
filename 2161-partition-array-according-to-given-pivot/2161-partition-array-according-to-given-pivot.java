class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        if(nums.length == 1){
            return nums;
        }
        List<Integer> smallValues = new ArrayList<Integer>();
        List<Integer> largeValues = new ArrayList<Integer>();
        int equalValues = 0;
        for(int num : nums){
            if(num < pivot){
                smallValues.add(num);
            }else if(num == pivot){
                equalValues++;
            }else{
                largeValues.add(num);
            }          
        }
        
        int checkEqual = equalValues;
        for(int index = 0; index < nums.length; index++){
            if(index < smallValues.size()){
                nums[index] = smallValues.get(index);
            }else if(equalValues-- > 0){
                nums[index] = pivot;
            }else{
                nums[index] = largeValues.get(index - (smallValues.size() + checkEqual));
            }
        }
        return nums;
    }
}