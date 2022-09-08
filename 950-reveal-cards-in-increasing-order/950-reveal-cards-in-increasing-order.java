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
    }
}