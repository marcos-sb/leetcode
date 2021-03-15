class Solution2 {
    public int distributeCandies(int[] candyType) {
        final var maxCandies = candyType.length / 2;
        final var types = new HashSet<Integer>();
        for (var type : candyType) types.add(type);
        return Math.min(maxCandies, types.size());
    }
}
