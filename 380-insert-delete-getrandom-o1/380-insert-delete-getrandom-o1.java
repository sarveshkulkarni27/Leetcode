class RandomizedSet {

    Set<Integer> numberSet;
    List<Integer> numberList;
    public RandomizedSet() {
        numberSet = new HashSet<>();
        numberList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!numberSet.contains(val)){
            numberSet.add(val);
            numberList.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(numberSet.contains(val)){
            numberSet.remove(val);
            numberList.remove(Integer.valueOf(val));
            return true;
        }
        return false;      
    }
    
    public int getRandom() {
        int random = (int) ((Math.random() * (numberList.size() - 0)) + 0);
        return numberList.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */