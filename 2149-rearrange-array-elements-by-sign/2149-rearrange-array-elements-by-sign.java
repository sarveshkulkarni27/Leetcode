class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        
        for(int num : nums){
            if(num < 0){
                negativeNumbers.add(num);
            }else{
                positiveNumbers.add(num);
            }
        }
        
        for(int index = 0; index < positiveNumbers.size(); index++){
            nums[index * 2] = positiveNumbers.get(index);
            nums[(index * 2) + 1] = negativeNumbers.get(index);
        }
        
        return nums;
    }
}