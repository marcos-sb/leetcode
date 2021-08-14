class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k >= arr.length)
            return 0;
        
        final var freq = new HashMap<Integer, Integer>(arr.length);
        for (var n : arr) freq.put(n, freq.getOrDefault(n, 0)+1);
        
        final Comparator<Integer> cmp =
            (a,b) -> Integer.compare(freq.get(a), freq.get(b));
        final var pq = new PriorityQueue<Integer>(cmp);
        for (var key : freq.keySet()) pq.offer(key);
        
        while (!pq.isEmpty()) {
            final var first = pq.poll();
            final var ffirst = freq.get(first);
            k -= ffirst;
            if (k >= 0) freq.remove(first);
            else break;
        }
        
        return freq.size();
    }
}
