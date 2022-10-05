class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Queue<int[]> queue = new LinkedList<int[]>();
        Set<Integer> visited = new HashSet<>();
        int maxTimeToInform = 0;
        
        for(int index = 0; index < manager.length; index++){
            if(manager[index] == -1) continue;
            List<Integer> subordinates = adjacencyList.getOrDefault(manager[index], new ArrayList<>());
            subordinates.add(index);
            adjacencyList.put(manager[index], subordinates);
        }
        
        queue.add(new int[]{headID, informTime[headID]});
        visited.add(headID);
        
        while(!queue.isEmpty()){
            int[] currentManager = queue.poll();
            maxTimeToInform = Math.max(maxTimeToInform, currentManager[1]);
            if(adjacencyList.containsKey(currentManager[0])){
                for(int subordinate : adjacencyList.get(currentManager[0])){
                    if(!visited.contains(subordinate)){
                        visited.add(subordinate);
                        queue.add(new int[]{subordinate, currentManager[1] + informTime[subordinate]});
                    }
                }
            }
        }
        return maxTimeToInform;
    }
}