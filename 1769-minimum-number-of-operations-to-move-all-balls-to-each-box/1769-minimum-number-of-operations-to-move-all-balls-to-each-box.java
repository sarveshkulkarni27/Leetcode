class Solution {
    public int[] minOperations(String boxes) {
        char[] ch = boxes.toCharArray();
        int[] left = new int[ch.length];
        int[] right = new int[ch.length];
        
        int count = ch[0] - '0';
        
        for(int index = 1; index < ch.length; index++){
            left[index] = count + left[index - 1];
            count += ch[index] - '0';
        }
        
        count = ch[ch.length - 1] - '0';
        for(int index = right.length - 2; index >= 0; index--){
            right[index] = count + right[index + 1];
            count += ch[index] - '0';
        }
        
        for(int index = 0; index < ch.length; index++){
            left[index] += right[index];
        }
        
        return left;
    }
}