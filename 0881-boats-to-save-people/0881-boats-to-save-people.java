class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int numberOfBoats = 0;
        while(left <= right){
            int leftSize = people[left];
            int rightSize = people[right];
            if(leftSize + rightSize <= limit){        
                left++;
            }
            right--;
            numberOfBoats++;
        }
        return numberOfBoats;
    }
}