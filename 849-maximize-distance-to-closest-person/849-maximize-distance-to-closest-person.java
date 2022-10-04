class Solution {
    public int maxDistToClosest(int[] seats) {
        int previous = -1;
        int maxDistance = -1;
        for(int index = 0; index < seats.length; index++){
            if(seats[index] == 1){
                if(previous == -1){
                    if(index != 0){
                        maxDistance = index;
                    }
                }else{
                    maxDistance = Math.max(maxDistance, (index - previous) / 2);
                }
                previous = index;                
            }
        }
        maxDistance = Math.max(maxDistance, (seats.length - 1 - previous));
        return maxDistance;
    }
}