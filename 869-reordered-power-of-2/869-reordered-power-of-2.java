class Solution {
    public boolean reorderedPowerOf2(int n) {
        String integerLength = "" + n;
        int length = integerLength.length();
        
        Map<Character, Integer> countMap = new HashMap<>();
        for(char ch : integerLength.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        int size = 0;
        int number = 1;
        while(true){
            String currNumber = "" + number;
            if(currNumber.length() == length){
                Map<Character, Integer> currMap = new HashMap<>();
                for(char ch : currNumber.toCharArray()){
                    currMap.put(ch, currMap.getOrDefault(ch, 0) + 1);
                }
                
                boolean flag = true;
                for(char ch : countMap.keySet()){
                    if(!currMap.containsKey(ch)){
                        flag = false;
                        break;                           
                    }
                    else if(currMap.containsKey(ch) && countMap.get(ch) != currMap.get(ch)){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                    return true;
                }
            }else if(currNumber.length() > length){
                return false;
            }
            number *= 2;
        }
    }
}