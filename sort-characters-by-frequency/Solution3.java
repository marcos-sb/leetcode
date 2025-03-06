class Solution {
    public String frequencySort(String s) {
        final var counts = new int[100];
        for (var c : s.toCharArray()) {
            counts[c-'0']++;
        }
        final var heap = new PriorityQueue<Character>((a,b) -> Integer.compare(counts[b-'0'], counts[a-'0']));
        for (var i = 0; i < counts.length; i++) {
            final var count = counts[i];
            if (0 < count) heap.offer((char) (i+'0'));
        }
        final var res = new StringBuilder();
        while (!heap.isEmpty()) {
            final var c = heap.poll();
            for (var i = 0; i < counts[c-'0']; i++)
                res.append(c);
        }
        return res.toString();
    }
}
