class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> finalList = new ArrayList<>();
        
        for(String word : words){
            
            Map<Character, Character> mapCharacter = new HashMap<>();
            Set<Character> checkCharacter = new HashSet<>();
            Set<Character> wordCharacter = new HashSet<>();
            boolean check = true;
            for(int index = 0; index < word.length(); index++){
                if(index == 0){
                    mapCharacter.put(pattern.charAt(index), word.charAt(index));
                    checkCharacter.add(pattern.charAt(index));
                    wordCharacter.add(word.charAt(index));
                }else{
                    if(checkCharacter.contains(pattern.charAt(index))){
                        if(mapCharacter.get(pattern.charAt(index)) != word.charAt(index)){
                            check = false;
                            break;
                        }
                    }else{
                        if(wordCharacter.contains(word.charAt(index))){
                            check = false;
                            break;                           
                        }else{
                            mapCharacter.put(pattern.charAt(index), word.charAt(index));
                            checkCharacter.add(pattern.charAt(index));
                            wordCharacter.add(word.charAt(index));                          
                        }
                    }
                }
            }
            if(check){
                finalList.add(word);
            }
        }
        return finalList;
    }
}