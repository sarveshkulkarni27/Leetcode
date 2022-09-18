class MyCalendar {

    PriorityQueue<int[]> calendar;
    int prevStart = -1;
    int prevEnd = -1;
    public MyCalendar() {
        this.calendar = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        // System.out.println(start + " " + end + " " + calendar.size());
        if(calendar.size() == 0){
            calendar.add(new int[]{start, end});
            return true;
        }else{
            PriorityQueue<int[]> currentCalendar = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);;
            while(!calendar.isEmpty()){
                int[] currDates = calendar.poll();
                // System.out.println(Arrays.toString(currDates));
                if(currDates[1] <= start || end <= currDates[0]){
                    // System.out.println("In");
                    currentCalendar.add(currDates);
                }else{
                    // System.out.println("Out");
                    while(!currentCalendar.isEmpty()){
                        calendar.add(currentCalendar.poll());
                    }
                    calendar.add(currDates);
                    return false;
                }
                
            }
            calendar = new PriorityQueue<int[]>(currentCalendar); 
            calendar.add(new int[]{start, end});
            return true;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */