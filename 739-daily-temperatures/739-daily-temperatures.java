class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> previousTemperatures = new Stack<Integer>();
        int[] answer = new int[temperatures.length];
        for(int index = temperatures.length - 1; index >= 0; index--){
            while(!previousTemperatures.isEmpty() && temperatures[previousTemperatures.peek()] <= temperatures[index]){
                previousTemperatures.pop();
            }
            if(!previousTemperatures.isEmpty()){
                answer[index] = previousTemperatures.peek() - index;
            }
            previousTemperatures.push(index);        
        }
        return answer;
    }
}