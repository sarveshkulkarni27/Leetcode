class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length == 1){
            return deck;
        }
        Arrays.sort(deck);
        
        int[] increasingArray = new int[deck.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.add(deck[deck.length - 1]);
        int pointer = deck.length - 2;
        while(pointer >= 0){
            int lastVal = deque.pollLast();
            deque.addFirst(lastVal);
            deque.addFirst(deck[pointer--]);
        }
        
        for(int index = 0; index < increasingArray.length; index++){
            increasingArray[index] = deque.pop();
        }
        
        return increasingArray;
//         1, 2, 3, 4, 5, 6
//         1    4  2   6    3  5
            
//         2  6   3.  5  4

//         3. 5. 4  6

//         4. 6. 5
            
//         5 6
            
//         6
            
            
            
//         1 2 3 4 5 6 7 8 9 10. 11
            
//         1.9 2.8 3.7 4.10 5.11 6        1.9 2.7 3.11 4.8 5.10 6
            
//         2 8 3 7 4 10 5 11 6 9
        
//         3 7 4 10 5 11 6 9 8
            
//         4 10 5 11 6 9 8 7
        
//         5 11 6 9 8 7 10
            
//         6 9 8 7 10 11
            
//     7    8 7 10 11 9
            
//     8    10 11 9 7
            
//     9    9 7 11
            
//     10   11 7
            
//     11    7
    }
}