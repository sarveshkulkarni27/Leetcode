class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redAdjacencyList = new HashMap<>();
        Map<Integer, List<Integer>> blueAdjacencyList = new HashMap<>();
        
        Queue<int[]> trackNodes = new LinkedList<int[]>();
        Set<Integer> redVisited = new HashSet<>();
        Set<Integer> blueVisited = new HashSet<>();
        int[] answer = new int[n];
        
        int red = 0;
        int blue = 0;
        while(red < redEdges.length || blue < blueEdges.length){
            if(red < redEdges.length){
                List<Integer> redList = redAdjacencyList.getOrDefault(redEdges[red][0], new ArrayList<Integer>());
                redList.add(redEdges[red][1]);
                redAdjacencyList.put(redEdges[red][0], redList);
                if(redEdges[red][0] == 0){
                    trackNodes.add(new int[]{redEdges[red][0], redEdges[red][1], 0, 1});
                    redVisited.add(redEdges[red][0]);
                }
                red++;
            }
            if(blue < blueEdges.length){
                List<Integer> blueList = blueAdjacencyList.getOrDefault(blueEdges[blue][0], new ArrayList<Integer>());
                blueList.add(blueEdges[blue][1]);
                blueAdjacencyList.put(blueEdges[blue][0], blueList);
                if(blueEdges[blue][0] == 0){
                    trackNodes.add(new int[]{blueEdges[blue][0], blueEdges[blue][1], 1, 1});
                    blueVisited.add(blueEdges[blue][0]);
                }  
                blue++;
            }         
        }
        
        while(!trackNodes.isEmpty()){
            int[] currentNode = trackNodes.poll();
            if(currentNode[1] != 0 && (answer[currentNode[1]] == 0 || currentNode[3] < answer[currentNode[1]])){
                answer[currentNode[1]] = currentNode[3];
            }
            if(currentNode[2] == 0 && blueAdjacencyList.containsKey(currentNode[1])){
                for(int destination : blueAdjacencyList.get(currentNode[1])){
                    if(!blueVisited.contains(destination)){
                        blueVisited.add(destination);
                        trackNodes.add(new int[]{currentNode[1], destination, 1, currentNode[3] + 1});
                    }             
                }
            }else if(currentNode[2] == 1 && redAdjacencyList.containsKey(currentNode[1])){
                 for(int destination : redAdjacencyList.get(currentNode[1])){
                    if(!redVisited.contains(destination)){
                        redVisited.add(destination);
                        trackNodes.add(new int[]{currentNode[1], destination, 0, currentNode[3] + 1});
                    }
                }               
            }
        }
        
        if(answer.length > 0){
            for(int index = 1; index < answer.length; index++){
                if(answer[index] == 0){
                    answer[index] = -1;
                }
            }
        }
        return answer;
    }
}