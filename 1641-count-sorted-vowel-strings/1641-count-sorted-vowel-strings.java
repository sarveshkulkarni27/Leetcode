class Solution {
    int count = 0;
    public int countVowelStrings(int n) {
        char[] vowelArray = new char[]{'a', 'e', 'i', 'o', 'u'};
        
        for(int index = 0; index < vowelArray.length; index++){
            // StringBuilder sb = new StrinBuilder(vowelArray[index]);
            getVowels(n - 1, vowelArray, index);
        }
        return count;
    }
    
    public void getVowels(int remainLength, char[] vowelArray, int position){
        if(remainLength == 0){
            count++;
            return;
        }
        for(int currPos = position; currPos < vowelArray.length; currPos++){          
            getVowels(remainLength - 1, vowelArray, currPos);
        }
    }
}