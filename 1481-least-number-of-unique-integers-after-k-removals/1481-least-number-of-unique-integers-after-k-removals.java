class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> uniqueElements = new PriorityQueue<Integer>();
        
        for(int val : countMap.values()){
            uniqueElements.add(val);
        }
        
        while(k > 0){
            int currentvalue = uniqueElements.peek();
            if(currentvalue <= k){
                uniqueElements.poll();
                k -= currentvalue;
            }else{
                break;
            }
        }
        return uniqueElements.size();
    }
}