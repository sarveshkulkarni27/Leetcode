class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> minimumCosts = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        
        for(int[] cost : costs){
            minimumCosts.add(new int[]{cost[0], cost[1], cost[0] - cost[1]});
        }
        
       
        int b = 0;
        int totalCost = 0;
        while(!minimumCosts.isEmpty()){
            int[] currentCost = minimumCosts.poll();
            if(b++ < costs.length / 2){
                totalCost += currentCost[0];
            }else{
                totalCost += currentCost[1];
            }
        }
        return totalCost;
    }
}