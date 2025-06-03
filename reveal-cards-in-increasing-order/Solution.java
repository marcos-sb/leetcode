package reveal_cards_in_increasing_order;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        final var q = new ArrayDeque<Integer>();
        for (int i = 0; i < deck.length; i++) { //n
            q.add(i);
        }
        final var l = new ArrayList<Integer>();
        while (true) { //n
            if (q.isEmpty()) break;
            final var headIndex = q.poll();
            l.add(headIndex);
            if (q.isEmpty()) break;
            q.add(q.poll());
        }
        Arrays.sort(deck); //n*logn
        final var res = new int[deck.length];
        int j = 0;
        for (Integer i : l) { //n
            res[i] = deck[j++];
        }
        return res;
    }
}
