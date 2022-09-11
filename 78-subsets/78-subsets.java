class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        return getSubsets(0, nums.length - 1, output, result, nums);
    }
    
    public List<List<Integer>> getSubsets(int source, int destination, List<Integer> output, List<List<Integer>> result, int[] nums){
        // if(source == destination){
        //     result.add(output);
        //     return;
        // }
        result.add(new ArrayList<>(output));
        for(int index = source; index <= destination; index++){
            output.add(nums[index]);
            getSubsets(index + 1, nums.length - 1, output, result, nums);
            output.remove(output.size() - 1);
        }
        return result;
    }
}