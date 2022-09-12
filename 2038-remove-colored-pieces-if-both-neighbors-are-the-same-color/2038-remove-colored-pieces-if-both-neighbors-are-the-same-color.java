class Solution {
    public boolean winnerOfGame(String colors) {
        if(colors.length() == 2){
            return false;
        }
        int countA = 0;
        int countB = 0;
        for(int index = 1; index < colors.length() - 1; index++){
            if(colors.charAt(index) == 'A' && colors.charAt(index - 1) == 'A' && colors.charAt(index + 1) == 'A'){
                countA++;
            }else if(colors.charAt(index) == 'B' && colors.charAt(index - 1) == 'B' && colors.charAt(index + 1) == 'B'){
                countB++;
            }
        }
        
        if(countA > countB){
            return true;
        }
        return false;
    }
}