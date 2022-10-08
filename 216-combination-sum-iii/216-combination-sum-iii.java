class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        return getCombinations(allCombinations, new ArrayList<>(), k, n, 0, 0);
    }
    
    public List<List<Integer>> getCombinations(List<List<Integer>> allCombinations, List<Integer> currentCombination, int k, int n, int total, int currentStart){
        // if(currentCombination.size() == k - 1){
        //     if(!currentCombination.contains(n - total)){
        //         currentCombination.add(n - total);
        //         allCombinations.add(new ArrayList<Integer>(currentCombination));
        //         currentCombination.remove(currentCombination.size() - 1);
        //         System.out.println(currentStart + 1 + " Return " + " " + total + " " + currentCombination + " " + allCombinations);
        //     }
        //     return allCombinations;
        // }
        if(currentCombination.size() == k && total == n){
                allCombinations.add(new ArrayList<Integer>(currentCombination));
                // System.out.println(currentStart + 1 + " Return " + " " + total + " " + currentCombination + " " + allCombinations);
            return allCombinations;
        }        
        for(int number = currentStart + 1; number <= 9; number++){
            if(!currentCombination.contains(number) && total + number <= n){
                currentCombination.add(number);
                // System.out.println(currentStart + 1 + " " + number + " " + total + " " + currentCombination);
                getCombinations(allCombinations, currentCombination, k, n, total + number, number);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
        return allCombinations;
    }
}