class Solution {
    public int minIncrementForUnique(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        
        List<Integer> val = new ArrayList<Integer>();
        for(int number = min; number <= max; number++){
            if(!frequencyMap.containsKey(number)){
                val.add(number);
            }
        }
        
        int counter = 0;
        int total = 0;
        int lastVal = -1;
        for(int number = min; number <= max; number++){
            if(frequencyMap.containsKey(number) && frequencyMap.get(number) > 1){
                int value = frequencyMap.get(number);
                while(value > 1 && counter < val.size()){
                    if(val.get(counter) <= number){
                        counter++;
                        continue;
                    }
                    value--;
                    total += val.get(counter++) - number;
                    if(counter == val.size()){
                        lastVal = max + 1;
                    }
                }
                if(lastVal == -1 && val.size() == 0){
                    lastVal = max + 1;
                }
                while(value > 1){
                    if(lastVal <= number){
                        lastVal++;
                        continue;
                    }
                    value--;
                    total += lastVal++ - number;
                }
            }
        }
        return total;
    }
}