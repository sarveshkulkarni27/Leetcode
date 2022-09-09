class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> stack1 = new ArrayList<Integer>();
        List<Integer> stack2 = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<>();
        for(int factor = 1; factor <= n; factor++){
            if(n % factor == 0){
                
                int val = n / factor;
                
                if(visited.contains(factor)){
                    break;
                }
                
                visited.add(val);
                stack1.add(factor);
                if(factor != val){
                    stack2.add(val);
                }
                
                if(stack1.size() == k || factor == val){
                    break;
                }
            }
        }
        
        System.out.println(stack1);
        System.out.println(stack2);

        if(k <= stack1.size()){
            // int diff = stack1.size() - k;
            // int returnVal = 0;
            // while(diff-- >= 0){
            //     returnVal = stack1.pop();
            // }
            return stack1.get(k - 1);
        }else if(k <= stack1.size() + stack2.size()){
            int diff = k - stack1.size();
            // int returnVal = 0;
            // while(diff-- > 0){
            //     returnVal = stack2.pop();
            // }
            System.out.println(diff);
            return stack2.get(stack2.size() - diff);            
        }else{
            return -1;
        }
    }
}