class Solution {
    public int minDeletions(String s) {
        int[] characterFrequency = new int[26];
        for(char ch : s.toCharArray()){
            characterFrequency[ch - 'a']++;
        }
        
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        Set<Integer> freq = new HashSet<>();
        for(int index = 0; index < 26; index++){
            freq.add(characterFrequency[index]);
            frequencyCount.put(characterFrequency[index], frequencyCount.getOrDefault(characterFrequency[index], 0) + 1);
        }
        int countDeletions = 0;
        for(int index = 0; index < 26; index++){
            if(frequencyCount.get(characterFrequency[index]) >= 2){
                int val = characterFrequency[index];
                int count = frequencyCount.get(characterFrequency[index]);
                while(val > 0 && freq.contains(val)){
                    countDeletions++;
                    val--;
                }
                frequencyCount.put(characterFrequency[index], count - 1);
                freq.add(val);
            }
        }
        return countDeletions;
    }
}