class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] uamArray = new int[k];
        
        Map<Integer, Set<Integer>> trackUserActivityMap = new HashMap<>();
        
        for(int[] userLog : logs){
            Set<Integer> activeMinutes = trackUserActivityMap.getOrDefault(userLog[0], new HashSet<Integer>());
            activeMinutes.add(userLog[1]);
            trackUserActivityMap.put(userLog[0], activeMinutes);
        }
        
        for(int key : trackUserActivityMap.keySet()){
            uamArray[trackUserActivityMap.get(key).size() - 1]++;
        }
        
        return uamArray;
    }
}