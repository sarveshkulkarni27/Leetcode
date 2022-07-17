class Solution {
    public int findKthLargest(int[] nums, int k) {
        Map<Integer, Integer> trackCountMap = new HashMap<Integer, Integer>();
        int max = -100000;
        int min = 100000;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
            trackCountMap.put(num, trackCountMap.getOrDefault(num, 0) + 1);
        }
        int kthLargestNumber = 0;
        for(int number = max; number >= min; number--){
            if(trackCountMap.containsKey(number)){
                k -= trackCountMap.get(number);
            }
            if(k <= 0){
                kthLargestNumber = number;
                break;
            }
        }
        return kthLargestNumber;
    }
}