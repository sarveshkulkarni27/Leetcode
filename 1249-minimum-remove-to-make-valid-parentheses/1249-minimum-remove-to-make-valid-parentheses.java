class Solution {
    
        class pair {
            char c ;
            int index;
            pair(char c, int index){
                this.c = c;
                this.index = index;
            }            
        }    
    public String minRemoveToMakeValid(String s) {
        // Stack<char[]> paranthesis = new Stack<>();
        Stack<Map<Character, Integer>> paranthesis = new Stack<>();
        Stack<pair> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int index = 0; index < s.length(); index++){
            char ch = s.charAt(index);
            if(ch == '('){
                // paranthesis.add(new char[]{ch, Integer.toString(index).charAt(0)});
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
        // System.out.println(sb.toString());
        while(!paranthesis.isEmpty()){
            Map<Character, Integer> currMap = paranthesis.pop();
            // System.out.println(charArray[1]);
            sb.setCharAt(currMap.entrySet().iterator().next().getValue(), ',');
        }       
       // String result = sb.toString();
       //  result = result.replace(",","");
       //  return result;        
        return sb.toString().replace(",", "");
    }
}