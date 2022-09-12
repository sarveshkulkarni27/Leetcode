class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> uniqueElements = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        
        for(int key : countMap.keySet()){
            uniqueElements.add(new int[]{key, countMap.get(key)});
        }
        
        while(k > 0){
            int[] currentArray = uniqueElements.peek();
            if(currentArray[1] <= k){
                uniqueElements.poll();
                k -= currentArray[1];
            }else{
                break;
            }
        }
        return uniqueElements.size();
    }
}