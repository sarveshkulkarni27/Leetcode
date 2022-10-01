class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> availabilityMap = new HashMap<>();
        Map<Integer, Integer> vacancyMap = new HashMap<>();
        for(int num : nums){
            availabilityMap.put(num, availabilityMap.getOrDefault(num, 0) + 1);
        }

        for(int num : nums){
            if(availabilityMap.get(num) <= 0){
                continue;
            }
            if(vacancyMap.getOrDefault(num, 0) > 0){
                availabilityMap.put(num, availabilityMap.getOrDefault(num, 0) - 1);
                vacancyMap.put(num, vacancyMap.getOrDefault(num, 0) - 1);
                vacancyMap.put(num + 1, vacancyMap.getOrDefault(num + 1, 0) + 1);
            }
            else if(availabilityMap.getOrDefault(num, 0) > 0 && availabilityMap.getOrDefault(num + 1, 0) > 0 
                   && availabilityMap.getOrDefault(num + 2, 0) > 0){
                availabilityMap.put(num, availabilityMap.getOrDefault(num, 0) - 1);
                availabilityMap.put(num + 1, availabilityMap.getOrDefault(num + 1, 0) - 1);
                availabilityMap.put(num + 2, availabilityMap.getOrDefault(num + 2, 0) - 1);
                
                vacancyMap.put(num + 3, vacancyMap.getOrDefault(num + 3, 0) + 1);
            }else if(availabilityMap.getOrDefault(num, 0) > 0 && (availabilityMap.getOrDefault(num + 1, 0) <= 0 || availabilityMap.getOrDefault(num + 2, 0) <= 0)){
                return false;
            }
        }
        return true;
    }
}