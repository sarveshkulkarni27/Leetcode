class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> routes = new ArrayList<>();
        
        for(int start : graph[0]){
            List<Integer> newRoute = new ArrayList<>();
            newRoute.add(0);
            
            getRoute(graph, start, newRoute, routes);
            
            // routes.add(newRoute);
        }
        return routes;
    }
    
    public void getRoute(int[][] graph, int position, List<Integer> newRoute, List<List<Integer>> routes){
        if(position == graph.length - 1){
            newRoute.add(position);
            routes.add(new ArrayList<>(newRoute));
            return;
        }
        newRoute.add(position);
        
        for(int nextPos : graph[position]){       
            getRoute(graph, nextPos, newRoute, routes);
            newRoute.remove(newRoute.size() - 1);
        }
                
    }
}