class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        int maxChangeIndex = 0;
        for(int index = 0; index < palindrome.length(); index++){
            if(palindrome.length() % 2 == 1 && index == palindrome.length() / 2){
                continue;
            }
            int val = palindrome.charAt(index) - 'a';
            if(val > 0){
                return palindrome.substring(0, index) + 'a' + palindrome.substring(index + 1, palindrome.length());
            }else{
                maxChangeIndex = index;
            }
        }
        return palindrome.substring(0, maxChangeIndex) + 'b' + palindrome.substring(maxChangeIndex + 1, palindrome.length());
    }
}