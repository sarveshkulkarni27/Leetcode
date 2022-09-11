class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> countPairs = new HashMap<>();
        
        for(String num : nums){
            countPairs.put(num, countPairs.getOrDefault(num, 0) + 1);
        }
        
        int totalPairs = 0;
        for(int index = 1; index < target.length(); index++){
            String s1 = target.substring(0, index);
            String s2 = target.substring(index, target.length());
            
            if(countPairs.containsKey(s1) && countPairs.containsKey(s2)){
                int countS1 = countPairs.get(s1);                
                if(!s1.equals(s2)){
                    
                    int countS2 = countPairs.get(s2);   
                    totalPairs += countS1 * countS2;
                    
                }else{
                    totalPairs += countS1 * (countS1 - 1);
                }
            }
        }
        return totalPairs;
    }
    
}