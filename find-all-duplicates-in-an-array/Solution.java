class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        final var counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counts.putIfAbsent(num, 0);
            counts.put(num, counts.get(num)+1);
        }
        return counts.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
