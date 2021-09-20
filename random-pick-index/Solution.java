class Solution {
    private final Map<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<>(nums.length);
        for (var i = 0; i < nums.length; i++) {
            final var n = nums[i];
            map.computeIfAbsent(n, k -> new ArrayList<>())
               .add(i);
        }
    }
    
    public int pick(int target) {
        final var indices = map.get(target);
        final var rndIdx = ThreadLocalRandom.current().nextInt(0, indices.size());
        return indices.get(rndIdx);
    }
}
