class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        
        List<List<Integer>> groups = new ArrayList<>();
        
        for(int groupSize = 0; groupSize < groupSizes.length; groupSize++){
            
            List<Integer> groupList = groupMap.getOrDefault(groupSizes[groupSize], new ArrayList<Integer>());
            groupList.add(groupSize);
            
            if(groupSizes[groupSize] == groupList.size()){
                groups.add(groupList);
                groupList = new ArrayList<>();
            }
            
            groupMap.put(groupSizes[groupSize], groupList);
            
            
            
        }
        
        return groups;
    }
}