class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> previousTemperatures = new Stack<int[]>();
        int[] answer = new int[temperatures.length];
        
        for(int index = 0; index < temperatures.length; index++){
            while(!previousTemperatures.isEmpty() && previousTemperatures.peek()[0] < temperatures[index]){
                int position =  previousTemperatures.pop()[1];
                answer[position] = index - position;
            }
            previousTemperatures.push(new int[]{temperatures[index], index});
        }
        return answer;
    }
}