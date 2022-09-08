class CustomStack {

    List<Integer> stackList;
    int maxSize = 0;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stackList = new ArrayList<>();
    }
    
    public void push(int x) {
        if(stackList.size() < maxSize){
            stackList.add(x);
        }
    }
    
    public int pop() {
        if(stackList.size() > 0){
            int lastElement = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            return lastElement;
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        k = k <= stackList.size() ? k : stackList.size();

        for(int index = 0; index < k; index++){
            int currVal = stackList.get(index);
            stackList.set(index, val + currVal);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */