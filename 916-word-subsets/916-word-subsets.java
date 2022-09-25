class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> universalWords = new ArrayList<String>();
        Map<Character, Integer> word2Count = new HashMap<>();
        for(int index = 0; index < words2.length; index++){
            Map<Character, Integer> character2Count = new HashMap<>();
            for(char ch : words2[index].toCharArray()){
                character2Count.put(ch, character2Count.getOrDefault(ch, 0) + 1);
            }
            
            for(char key : character2Count.keySet()){
                int val = Math.max(word2Count.getOrDefault(key, 0), character2Count.get(key));
                word2Count.put(key, val);
            }
            
        }
        
        for(String word1 : words1){
            Map<Character, Integer> character1Count = new HashMap<>();
            for(char ch : word1.toCharArray()){
                character1Count.put(ch, character1Count.getOrDefault(ch, 0) + 1);
            }
            boolean flag = true;
            
            for(char key : word2Count.keySet()){
                if(!character1Count.containsKey(key) || character1Count.get(key) < word2Count.get(key)){
                    flag = false;
                    break;                    
                }
            }
            
            if(flag){
                universalWords.add(word1);
            }
        }
        return universalWords;
    }
}