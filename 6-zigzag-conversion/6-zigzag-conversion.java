class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, String> zigZagMap = new HashMap<>();
        for(int index = 1; index <= numRows; index++){
            zigZagMap.put(index, new String());
        }
        
        int directionFlag = -1;
        int row = 1;
        for(char ch : s.toCharArray()){
            zigZagMap.put(row, zigZagMap.get(row) + ch);
            if(numRows != 1){
                if(row == 1 || row == numRows){
                    directionFlag *= -1;
                }
                row += directionFlag;                
            }

        }
        
        StringBuilder sb = new StringBuilder();
        for(int index = 1; index <= numRows; index++){
            sb.append(zigZagMap.get(index));
        }
        
        return sb.toString();
    }
}