class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        final var queue = new ArrayDeque<Integer>();
        for (var i = 0; i < deck.length; ++i) {
            queue.offer(i);
        }

        final var res = new int[deck.length];
        var i = 0;
        while (!queue.isEmpty()) {
            final var index = queue.poll();
            res[index] = deck[i++];

            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return res;
    }
}
