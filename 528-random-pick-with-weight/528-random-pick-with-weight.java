class Solution {

    List<Integer> normalizedList;
    public Solution(int[] w) {
        normalizedList = new ArrayList<>();
        normalizedList.add(w[0]);
        for(int index = 1; index < w.length; index++){
            normalizedList.add(normalizedList.get(index - 1) + w[index]);
        }
    }
    
    public int getBinarySearch(int left, int right, List<Integer> currentList, int target){
        if(left > right){
            return -1;
        }
        int middle = (left + right) / 2;
        if((middle == 0 || currentList.get(middle - 1) <= target) && currentList.get(middle) > target){
            return middle;
        }
        if((middle == currentList.size() - 1 || currentList.get(middle) > target) && currentList.get(middle - 1) <= target){
            return middle + 1;
        }
        if(currentList.get(middle) > target){
            return getBinarySearch(left, middle - 1, normalizedList, target);
        }else{
            return getBinarySearch(middle + 1, right, normalizedList, target);
        }
    }
    
    public int pickIndex() {
        //int random = (int) ((Math.random() * (normalizedList.size() - 0)) + 0);
        int random = (int) (Math.random() * (normalizedList.get(normalizedList.size() - 1)));
        return getBinarySearch(0, normalizedList.size() - 1, normalizedList, random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */