class Solution {
    int maxChainLength = 0;
    public int longestStrChain(String[] words) {
        Map<Integer, Set<String>> wordLengthMap = new HashMap<>();
        
        int max = -1 * Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String word : words){
            int wordLength = word.length();
            
            min = Math.min(min, wordLength);
            max = Math.max(max, wordLength);
            
            Set<String> wordList = wordLengthMap.getOrDefault(wordLength, new HashSet<String>());
            wordList.add(word);
            wordLengthMap.put(wordLength, wordList);
        }
        
        for(int count = max; count >= min; count--){
            if(wordLengthMap.containsKey(count)){
                Set<String> wordList = wordLengthMap.get(count);
                for(String word : wordList){
                    for(int index = 0; index < word.length(); index++){
                        StringBuilder newString = new StringBuilder(word);
                        newString = newString.deleteCharAt(index);
                        getDFS(newString, count - 1, min, wordLengthMap, 1);
                    }                     
                }
                
            }
        }
        return maxChainLength;
    }
    
    public void getDFS(StringBuilder word, int current, int min, Map<Integer, Set<String>> wordLengthMap, int count){
        maxChainLength = Math.max(maxChainLength, count); 
        if(current < min || (count + current - min) < maxChainLength){
            return;
        }
        if(wordLengthMap.containsKey(current)){
            Set<String> wordList = wordLengthMap.get(current);
            if(wordList.contains(word.toString())){
                for(int index = 0; index < word.length(); index++){
                    StringBuilder newString = new StringBuilder(word);
                    newString = newString.deleteCharAt(index);
                    getDFS(newString, current - 1, min, wordLengthMap, count + 1);
                }                
            }
        }        
    }
}