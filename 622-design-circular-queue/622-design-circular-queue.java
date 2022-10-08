class MyCircularQueue {
    int[] queue;
    int pointer = -1;
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        Arrays.fill(queue, - 1);
    }
    
    public boolean enQueue(int value) {        
        if(pointer == queue.length - 1){
            return false;
        }
        if(pointer == -1){
            queue[0] = value;
            pointer = 0;
        }else{
            queue[++pointer] = value;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(pointer == -1){
            return false;
        }
        for(int position = 0; position < pointer; position++){
            queue[position] = queue[position + 1];
        }
        queue[pointer--] = -1;
        return true;         
    }
    
    public int Front() {
        return queue[0];
    }
    
    public int Rear() {
        return pointer != -1 ? queue[pointer] : -1;
    }
    
    public boolean isEmpty() {
        return pointer == -1 ? true : false;
    }
    
    public boolean isFull() {
        return pointer == queue.length - 1 ? true : false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */