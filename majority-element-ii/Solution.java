class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>(3);
        for (var n : nums) {
            freqs.putIfAbsent(n,0);
            if (freqs.size() > 2) {
                freqs = freqs.entrySet().stream()
                    .map(e -> List.of(e.getKey(), e.getValue()-1))
                    .filter(l -> l.get(1) > 0)
                    .collect(Collectors.toMap(l -> l.get(0), l -> l.get(1)));
            }
            freqs.computeIfPresent(n, (el,count) -> count+1);
        }
        final Map<Integer,Integer> _freqs = new HashMap<>(freqs.size());
        for (var n : nums) {
            if (freqs.containsKey(n)) {
                _freqs.putIfAbsent(n,0);
                _freqs.computeIfPresent(n, (k,v) -> v+1);
            }
        }
        
        final var majority = nums.length / 3;
        
        return _freqs.entrySet().stream()
            .filter(e -> e.getValue() > majority)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
