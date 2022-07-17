class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> trackDuplicates = new HashSet<>();
        for(int num : nums){
            if(trackDuplicates.contains(num)){
                return true;
            }
            trackDuplicates.add(num);
        }
       return false; 
    }
}