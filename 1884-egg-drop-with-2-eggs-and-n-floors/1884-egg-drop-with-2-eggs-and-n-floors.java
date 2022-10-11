class Solution {
    public int twoEggDrop(int n) {
        
        int drop = 1;
        while(n > 0){
            n -= drop++;
        }
        
        return --drop;
    }
}