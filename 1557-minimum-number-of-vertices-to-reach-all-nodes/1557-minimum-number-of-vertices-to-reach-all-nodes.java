class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> verticesSet = new HashSet<>();
        
        for(List<Integer> edge : edges){
            verticesSet.add(edge.get(1));
        }
        
        List<Integer> verticesList = new ArrayList<>();
        for(int index = 0; index < n; index++){
            if(!verticesSet.contains(index)){
                verticesList.add(index);
            }
        }
        
        return verticesList;
    }
}