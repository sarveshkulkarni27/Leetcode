class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        List<List<Integer>> minDiffPairs = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(int index = 1; index < arr.length; index++){
            if(arr[index] - arr[index - 1] == minDiff){
                List<Integer> currentPair = new ArrayList<>();
                currentPair.add(arr[index - 1]);
                currentPair.add(arr[index]);
                minDiffPairs.add(currentPair);
            }else if(arr[index] - arr[index - 1] < minDiff){
                List<Integer> currentPair = new ArrayList<>();
                currentPair.add(arr[index - 1]);
                currentPair.add(arr[index]);
                minDiffPairs = new ArrayList<>();
                minDiffPairs.add(currentPair);
                minDiff = arr[index] - arr[index - 1];
            }
        }
        
        return minDiffPairs;
    }
}