class Solution {
        
    public String minRemoveToMakeValid(String s) {
        Stack<Map<Character, Integer>> paranthesis = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int index = 0; index < s.length(); index++){
            char ch = s.charAt(index);
            if(ch == '('){
                Map<Character, Integer> currMap = new HashMap<>();
                currMap.put(ch, index);
                paranthesis.add(currMap);
            }else if(ch == ')'){
                if(!paranthesis.isEmpty() && paranthesis.peek().entrySet().iterator().next().getKey() == '('){
                    paranthesis.pop();
                }else{
                    sb.setCharAt(index, ',');
                }
            }
        }
        while(!paranthesis.isEmpty()){
            Map<Character, Integer> currMap = paranthesis.pop();
            sb.setCharAt(currMap.entrySet().iterator().next().getValue(), ',');
        }       
      
        return sb.toString().replace(",", "");
    }
}