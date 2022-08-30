class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partions = new ArrayList<>();
        Map<Character, Integer> lastPosition = new HashMap<>();
        
        for(int index = 0; index < s.length(); index++){
            lastPosition.put(s.charAt(index), index);
        }
        
        int currentMax = -1;
        int start = 0;
        for(int index = 0; index < s.length(); index++){
            currentMax = Math.max(currentMax, lastPosition.get(s.charAt(index)));
            if(index == currentMax){
                partions.add(currentMax - start + 1);
                start = index + 1;
            }
        }
        return partions;
    }
}