class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partions = new ArrayList<>();
        Map<Character, Integer> lastPosition = new HashMap<>();
        
        for(int index = 0; index < s.length(); index++){
            lastPosition.put(s.charAt(index), index);
        }
        
        int currentMax = -1;
        
        for(int index = 0; index < s.length(); index++){
            if(currentMax == -1){
                if(lastPosition.get(s.charAt(index)) == index){
                    partions.add(index);
                }else{
                    currentMax = Math.max(currentMax, lastPosition.get(s.charAt(index)));
                }
            }
            else if(index == currentMax){
                partions.add(index);
                currentMax = -1;
            }else{
                currentMax = Math.max(currentMax, lastPosition.get(s.charAt(index)));
            }
        }
        if(partions.size() > 1){
            int temp = partions.get(0);
            for(int index = 1; index < partions.size(); index++){
                int val = partions.get(index) - temp;
                temp = partions.get(index);
                partions.set(index, val);
            }
        }
        partions.set(0, partions.get(0) + 1);
        return partions;
    }
}