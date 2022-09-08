class Solution {
    public int minimumKeypresses(String s) {
        Integer[] countArray = new Integer[26];
        Arrays.fill(countArray, 0);
        for(char ch : s.toCharArray()){
            countArray[ch - 'a']++;
        }
        
        // TreeMap<Integer, Integer> countMap = new TreeMap<>(Collections.reverseOrder());
        // for(int index = 0; index < 26; index++){
        //     if(countArray[index] != 0){
        //         countMap.put(countArray[index], countMap.getOrDefault(countArray[index], 0) + 1);
        //     }
        // }
        Arrays.sort(countArray, (a, b) -> b - a);
        int buttonPress = 0;
        for(int index = 0; index < 26; index++){
            if(index < 9){
                buttonPress += countArray[index];
            }else if(index < 18){
                buttonPress += 2 * countArray[index];
            }else{
                buttonPress += 3 * countArray[index];
            }
        }
        // int press = 1;
        // int letterCount = 0;
        // for(int key : countMap.keySet()){
        //     int currentLetterCount = countMap.get(key);
        //     for(int index = letterCount; index < letterCount + currentLetterCount; index++){
        //         if(index != 0 && index % 9 == 0){
        //             press++;
        //         }
        //          buttonPress += (key * press);
        //     }     
        //     letterCount += currentLetterCount;
        // }
        return buttonPress;
    }
}