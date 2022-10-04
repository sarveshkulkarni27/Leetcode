class Solution {
    public int kthGrammar(int n, int k) {
// 0
// 01
// 0110
// 01101001
// 0110100110010110
// 01101001100101101001011001101001
        // StringBuilder sb = new StringBuilder();
        // int count = 0;
        // while(count++ < n){
        //     if(count == 0){
        //         sb.append("0");
        //     }
        //     if(count == 1){
        //         sb = new StringBuilder("01");
        //     }else{
        //         sb.append(sb.substring((sb.length() / 2), sb.length()) + 
        //                  sb.substring(0, (sb.length() / 2)));
        //     }
        //     if(k <= sb.length()){
        //         return Character.getNumericValue((sb.toString().charAt(k - 1)));
        //     }
        // }
        // return Character.getNumericValue((sb.toString().charAt(k - 1)));
        return getRecursion(n, k);
    }
    
    public int getRecursion(int n, int k){
        if(n == 1 && k == 1){
            return 0;
        }
        
        int mid = (int) Math.pow(2, n - 1) / 2;
        if(k <= mid){
            return getRecursion(n - 1, k);
        }else{
            return getRecursion(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}