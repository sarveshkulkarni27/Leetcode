class Solution {
    public int[] constructArray(int n, int k) {
        int[] finalArray = new int[n];
        
        int index = 0;
        boolean front = true;
        int counter = 0;
        int nextVal = 0;
        boolean next = true;
        while(index < n){          
            if(k == 1){
                if(counter == 0){
                    finalArray[index] = index + 1;
                }else{
                    if(next){
                        finalArray[index] = nextVal++;
                    }else{
                        finalArray[index] = nextVal--;
                    }
                }                    
            }
            else{
                if(front){
                    finalArray[index] = (index / 2) + 1;
                    front = false;
                }else{
                    finalArray[index] = n - (index / 2);
                    front = true;
                }
                if(index > 0) k--;
                if(k == 1){
                    if(finalArray[index] <= n / 2){
                        nextVal = finalArray[index] + 1; 
                    }else{
                        nextVal = finalArray[index] - 1;
                       next = false; 
                    }
                }
                counter++;
            }
            index++;
        }
        return finalArray;
    }
}