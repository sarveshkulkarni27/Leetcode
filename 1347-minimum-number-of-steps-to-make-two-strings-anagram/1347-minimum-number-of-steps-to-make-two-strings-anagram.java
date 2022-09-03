class Solution {
    public int minSteps(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        int count = 0;
        
        for(char ch : s.toCharArray()){
            sFreq[ch - 'a']++;
        }
        
        for(char ch : t.toCharArray()){
            tFreq[ch - 'a']++;
        }
        
        for(int index = 0; index < 26; index++){
            if(tFreq[index] < sFreq[index]){
                count += sFreq[index] - tFreq[index];
            }
        }
        return count;
    }
}