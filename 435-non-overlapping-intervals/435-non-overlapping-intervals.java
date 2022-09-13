class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
                
        int prevEnd = intervals[0][1];
        int counter = 0;
        for(int index = 1; index < intervals.length; index++){
            if(intervals[index][0] < prevEnd){
                counter++;
            }else{
                prevEnd = intervals[index][1];
            }
        }
        
        return counter;
    }
}