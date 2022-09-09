class Solution {
    public int kthFactor(int n, int k) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        // Queue<Integer> stack2 = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<>();
        for(int factor = 1; factor <= n; factor++){
            if(n % factor == 0){
                
                int val = n / factor;
                
                if(visited.contains(factor)){
                    break;
                }
                
                visited.add(val);
                stack1.push(factor);
                if(factor != val){
                    // stack2.add(val);
                    stack2.push(val);
                }
                
                if(stack1.size() == k || factor == val){
                    break;
                }
            }
        }
        System.out.println(stack1);
        System.out.println(stack2);
        if(k <= stack1.size()){
            int diff = stack1.size() - k;
            int returnVal = 0;
            while(diff-- >= 0){
                returnVal = stack1.pop();
            }
            return returnVal;
        }else if(k <= stack1.size() + stack2.size()){
            int diff = k - stack1.size();
            System.out.println("Diff: " + diff);
            int returnVal = 0;
            while(diff-- > 0){
                //returnVal = stack2.poll();
                returnVal = stack2.pop();
                System.out.println(returnVal);
            }
            return returnVal;            
        }else{
            return -1;
        }
    }
}