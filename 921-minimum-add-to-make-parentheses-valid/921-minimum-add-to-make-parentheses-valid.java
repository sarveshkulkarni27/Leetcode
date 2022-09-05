class Solution {
    public int minAddToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            boolean match = false;
            if(sb.length() > 0 && ch == ')'){
                for(int index = sb.length() - 1; index >= 0; index--){
                    if(sb.charAt(index) == '('){
                        sb.deleteCharAt(index);
                        match = true;
                        break;
                    }
                }
            }
            if(!match){
                sb.append(ch);
            }
        }
        
        return sb.length();
    }
}