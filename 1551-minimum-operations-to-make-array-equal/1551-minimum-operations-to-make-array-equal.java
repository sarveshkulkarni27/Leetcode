class Solution {
    public int minOperations(int n) {
        int minOperations = 0;
        for(int index = 1; index <= n; index+=2){
            minOperations += (n - index);
        }
        
        return minOperations;
    }
}