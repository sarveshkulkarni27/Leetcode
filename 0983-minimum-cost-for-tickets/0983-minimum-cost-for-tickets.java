class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] yearDays = new int[366];
        int counter = 0;
        for(int index = 1; index < yearDays.length; index++){
            if(counter == days.length){
                break;
            }            
            if(index != days[counter]){
                yearDays[index] = yearDays[index - 1];
            }else{
                int oneDayPass = yearDays[index - 1] + costs[0];
                int sevenDayPass = costs[1];
                if(index - 7 >= 0){
                    sevenDayPass = yearDays[index - 7] + costs[1];    
                }
                int thirtyDayPass = costs[2];
                if(index - 30 >= 0){
                    thirtyDayPass = yearDays[index - 30] + costs[2];
                }
                yearDays[index] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
                counter++;

            }
        }
        
        return yearDays[days[days.length - 1]];
    }
}