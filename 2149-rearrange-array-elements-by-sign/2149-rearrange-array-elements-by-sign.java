class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int pos = 0;
        int neg = 1;
        int[] finalArray = new int[nums.length];
        for(int num : nums){
            if(num < 0){
                finalArray[neg] = num;
                neg += 2;
            }else{
                finalArray[pos] = num;
                pos += 2;
            }
        }
        
        return finalArray;
    }
}