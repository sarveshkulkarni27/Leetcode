class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> sort = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            sort.add(entry);
        }
        
        int[] topKElements = new int[k];
        for(int index = 0; index < topKElements.length; index++){
            topKElements[index] = sort.poll().getKey();
        }
        
        return topKElements;
    }
}