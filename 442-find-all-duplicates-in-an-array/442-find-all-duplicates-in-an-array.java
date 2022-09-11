class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicatesList = new ArrayList<Integer>();
        
        for(int index = 0; index < nums.length; index++){
            int value = Math.abs(nums[index]) - 1;
            if(nums[value] < 0){
                duplicatesList.add(value + 1);
            }else{
                nums[value] = -1 * nums[value];
            }
        }
        return duplicatesList;
    }
}