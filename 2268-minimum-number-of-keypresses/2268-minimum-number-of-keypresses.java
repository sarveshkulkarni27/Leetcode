class Solution {
    public int minimumKeypresses(String s) {
        int[] countArray = new int[26];
        
        for(char ch :s.toCharArray()){
            countArray[ch - 'a']++;
        }
        
        TreeMap<Integer, Integer> countMap = new TreeMap<>(Collections.reverseOrder());
        for(int index = 0; index < 26; index++){
            if(countArray[index] != 0){
                countMap.put(countArray[index], countMap.getOrDefault(countArray[index], 0) + 1);
            }
        }
        
        int buttonPress = 0;
        int press = 1;
        int letterCount = 0;
        // System.out.println(countMap);
        for(int key : countMap.keySet()){
            int currentLetterCount = countMap.get(key);
            for(int index = letterCount; index < letterCount + currentLetterCount; index++){
                if(index != 0 && index % 9 == 0){
                    press++;
                }
                 buttonPress += (key * press);
            }     
            letterCount += currentLetterCount;
        }
        return buttonPress;
    }
}