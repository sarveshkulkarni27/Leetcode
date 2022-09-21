class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        Map<Character, List<Character>> digitMap = new HashMap<>();
        int mainCount = 97;
        for(int index = 2; index <= 9; index++){
            if(index == 7 || index == 9){
                int count = 0;
                List<Character> characterList = new ArrayList<>();
                while(count++ != 4){
                    characterList.add((char) mainCount++);
                }
                digitMap.put((char)(index+'0'), characterList);
            }else{
                int count = 0;
                List<Character> characterList = new ArrayList<>();
                while(count++ != 3){
                    characterList.add((char) mainCount++);
                }
                digitMap.put((char)(index+'0'), characterList);                
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> finalString = new ArrayList<>();
        
        getDFS(sb, finalString, digitMap, digits, 0);
        return finalString;
    }
    
    public List<String> getDFS(StringBuilder sb, List<String> finalString, Map<Character, List<Character>> digitMap, String digits,int index){
        if(index == digits.length()){
            return finalString;
        }
        List<Character> characterList = digitMap.get(digits.charAt(index));
        for(char ch : characterList){
            sb.append(ch);
            getDFS(sb, finalString, digitMap, digits, index + 1);
            if(sb.length() == digits.length()){
                finalString.add(new String(sb.toString()));
            }
            
            sb.deleteCharAt(sb.length() - 1);
        }
        return finalString;
    }
}