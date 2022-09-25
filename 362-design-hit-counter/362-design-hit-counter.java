class HitCounter {

    Queue<Integer> hitQueue;
    public HitCounter() {
        hitQueue = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        while(!hitQueue.isEmpty() && (timestamp - hitQueue.peek() >= 300)){
            hitQueue.poll();
        } 
        hitQueue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!hitQueue.isEmpty() && (timestamp - hitQueue.peek() >= 300)){
            hitQueue.poll();
        }        
        return hitQueue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */