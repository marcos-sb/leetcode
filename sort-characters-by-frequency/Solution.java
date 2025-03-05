class Solution {
    public String frequencySort(String s) {
        final var counts = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        final Map.Entry<Character, Integer>[] arr = new Map.Entry[counts.size()];
        var i = 0;
        for (var e : counts.entrySet()) {
            arr[i++] = e;
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b.getValue(), a.getValue()));
        final var res = new StringBuilder();
        for (var e : arr) {
            var val = e.getValue();
            while (0 < val--) res.append(e.getKey());
        }
        return res.toString();
    }
}
