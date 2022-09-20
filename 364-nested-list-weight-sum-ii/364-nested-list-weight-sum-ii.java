/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxWeight = -1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> currentList = new ArrayList<>();
        List<Integer> weightList = new ArrayList<>();
        int depth = 1;
        
        getDepthList(nestedList, currentList, weightList, depth);
        int sum = 0;
        for(int pos = 0; pos < currentList.size(); pos++){
            sum += (maxWeight - weightList.get(pos) + 1) * currentList.get(pos);
        }
        
        return sum;
    }
    
    
    public void getDepthList(List<NestedInteger> nestedList, List<Integer> currentList, List<Integer> weightList, int depth){
        if(nestedList.size() == 0){
            maxWeight = Math.max(maxWeight, depth - 1);
            return;
        }

        for(int index = 0; index < nestedList.size(); index++){
            
            if(nestedList.get(index).isInteger()){
                maxWeight = Math.max(maxWeight, depth);
                currentList.add(nestedList.get(index).getInteger());
                weightList.add(depth);                    
            }else{
                getDepthList(nestedList.get(index).getList(), currentList, weightList, depth + 1);
            }
        }
    }
}











