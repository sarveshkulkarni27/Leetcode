class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int groupSize = 0; groupSize < groupSizes.length; groupSize++){
            
            min = Math.min(min, groupSizes[groupSize]);
            max = Math.max(max, groupSizes[groupSize]);
            
            List<Integer> groupList = groupMap.getOrDefault(groupSizes[groupSize], new ArrayList<Integer>());
            groupList.add(groupSize);
            groupMap.put(groupSizes[groupSize], groupList);
        }
        
        System.out.println(min);
        System.out.println(max);
        
        System.out.println(groupMap);
        
        List<List<Integer>> groups = new ArrayList<>();
        
        for(int groupSize = min; groupSize <= max; groupSize++){
            
            List<Integer> currentGroup = new ArrayList<>();
            List<Integer> currentList = new ArrayList<>();
            if(groupMap.containsKey(groupSize)){
                currentList = groupMap.get(groupSize);
            }
            for(int index = 0; index < currentList.size(); index++){
                if(currentGroup.size() == groupSize){
                    groups.add(currentGroup);
                    currentGroup = new ArrayList<>();
                    currentGroup.add(currentList.get(index));
                }else{
                    System.out.println(currentList.get(index));
                    currentGroup.add(currentList.get(index));
                }
            }
            if(currentGroup.size() == groupSize){
                groups.add(currentGroup);
                currentGroup = new ArrayList<>();
            }            
        }
        
        return groups;
    }
}