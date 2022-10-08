class Solution {

    int[] nums;
    int[] replicateNums;
    public Solution(int[] nums) {
        this.nums = nums;
        this.replicateNums = new int[nums.length];
        for(int index = 0; index < nums.length; index++){
            this.replicateNums[index] = nums[index];
        }
    }
    
    public int[] reset() {
        for(int index = 0; index < nums.length; index++){
            this.nums[index] = this.replicateNums[index];
        }
        return this.nums;
    }
    
    public int[] shuffle() {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        while(true){
            int random = (int)(Math.random() * this.replicateNums.length + 0);
            if(visited.contains(random)){
                continue;
            }
            visited.add(random);
            this.nums[count++] = this.replicateNums[random];
            if(visited.size() == this.replicateNums.length){
                break;
            }
        }
        return this.nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */