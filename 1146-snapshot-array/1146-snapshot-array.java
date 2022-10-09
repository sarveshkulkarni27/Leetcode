class SnapshotArray {

    Map<Integer, Map<Integer, Integer>> snapshotMap;
    Map<Integer, Integer> arrayMap;
    int totalSnaps = 0;
    public SnapshotArray(int length) {
        this.snapshotMap = new HashMap<>();
        this.arrayMap = new HashMap<>();
    }
    
    public void set(int index, int val) {   
        arrayMap.put(index, val);
    }
    
    public int snap() {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for(int key : arrayMap.keySet()){
            tempMap.put(key, arrayMap.get(key));
        }
        snapshotMap.put(totalSnaps, tempMap);
        return totalSnaps++;
    }
    
    public int get(int index, int snap_id) {
        if(snapshotMap.get(snap_id).containsKey(index)){
            return snapshotMap.get(snap_id).get(index);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */