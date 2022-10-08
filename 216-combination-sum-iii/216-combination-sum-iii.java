class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        return getCombinations(allCombinations, new ArrayList<>(), k, n, 0, 1);
    }
    
    public List<List<Integer>> getCombinations(List<List<Integer>> allCombinations, List<Integer> currentCombination, int k, int n, int total, int currentStart){
        if(currentCombination.size() == k && total == n){
            allCombinations.add(new ArrayList<Integer>(currentCombination));
            return allCombinations;
        }        
        for(int number = currentStart; number <= 9; number++){
            if(!currentCombination.contains(number) && total + number <= n){
                currentCombination.add(number);
                getCombinations(allCombinations, currentCombination, k, n, total + number, number + 1);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
        return allCombinations;
    }
}