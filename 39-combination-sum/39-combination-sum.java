class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinationList = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        getCombinationSum(0, combinationList, currentCombination, candidates, target);
        return combinationList;
    }
    
    public void getCombinationSum(int index, List<List<Integer>> combinationList, List<Integer> currentCombination, int[] candidates, int target){
        if(index < 0 || index >= candidates.length || target < 0){
            return;
        }
        if(target == 0){
            combinationList.add(new ArrayList<Integer>(currentCombination));
            return;
        }
        currentCombination.add(candidates[index]);
        getCombinationSum(index, combinationList, currentCombination, candidates, target - candidates[index]);
        currentCombination.remove(currentCombination.size() - 1);
        getCombinationSum(index + 1, combinationList, currentCombination, candidates, target);
    }
}