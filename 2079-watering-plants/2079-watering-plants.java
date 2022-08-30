class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int totalSteps = 0;
        int currentWaterCapacity = capacity;
        for(int index = 0; index < plants.length; index++){
            if(currentWaterCapacity < plants[index]){
                totalSteps += (2 * index) + 1;
                currentWaterCapacity = capacity - plants[index];
            }else{
                currentWaterCapacity -= plants[index];
                totalSteps++;
            }
        }
        return totalSteps;
    }
}