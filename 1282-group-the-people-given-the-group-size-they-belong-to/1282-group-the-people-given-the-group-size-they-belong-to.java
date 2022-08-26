class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        List<List<Integer>> groups = new ArrayList<>();
        
        for(int groupSize = 0; groupSize < groupSizes.length; groupSize++){
            
            min = Math.min(min, groupSizes[groupSize]);
            max = Math.max(max, groupSizes[groupSize]);
            
            List<Integer> groupList = groupMap.getOrDefault(groupSizes[groupSize], new ArrayList<Integer>());
            groupList.add(groupSize);
            
            if(groupSizes[groupSize] == groupList.size()){
                groups.add(groupList);
                groupList = new ArrayList<>();
            }
            
            groupMap.put(groupSizes[groupSize], groupList);
            
            
            
        }
        
        
        
//         for(int groupSize = min; groupSize <= max; groupSize++){
            
//             List<Integer> currentGroup = new ArrayList<>();
//             List<Integer> currentList = new ArrayList<>();
//             if(groupMap.containsKey(groupSize)){
//                 currentList = groupMap.get(groupSize);
//             }
//             for(int index = 0; index < currentList.size(); index++){
//                 if(currentGroup.size() == groupSize){
//                     groups.add(currentGroup);
//                     currentGroup = new ArrayList<>();
//                     currentGroup.add(currentList.get(index));
//                 }else{
//                     currentGroup.add(currentList.get(index));
//                 }
//             }
//             if(currentGroup.size() == groupSize){
//                 groups.add(currentGroup);
//                 currentGroup = new ArrayList<>();
//             }            
//         }
        
        return groups;
    }
}