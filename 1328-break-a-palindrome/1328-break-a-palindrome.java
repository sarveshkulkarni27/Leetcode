class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        for(int index = 0; index < palindrome.length() / 2; index++){
            int val = palindrome.charAt(index) - 'a';
            if(val > 0){
                return palindrome.substring(0, index) + 'a' + palindrome.substring(index + 1, palindrome.length());
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }
}