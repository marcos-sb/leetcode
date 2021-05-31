class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        final var maxSize = triangle.get(triangle.size()-1).size();
        final var cache = new Integer[maxSize][maxSize];
        return dfs(triangle, 0, 0, cache);
    }
    
    private static int dfs(List<List<Integer>> triangle, int r, int c, Integer[][] cache) {
        if (r == triangle.get(triangle.size()-1).size()-1)
            return triangle.get(r).get(c);
        
        if (cache[r][c] != null) return cache[r][c];
        
        int minPath = Integer.MAX_VALUE;
        for (var child : next(triangle, r, c)) {
            minPath = Math.min(minPath, dfs(triangle, child.get(0), child.get(1), cache));
        }
        
        return cache[r][c] = minPath + triangle.get(r).get(c);
    }

    private static List<List<Integer>> next(List<List<Integer>> triangle, int r, int c) {
        final List<List<Integer>> res = new ArrayList<>(2);

        final var newR = r+1;
        if (newR == triangle.size()) return res;
        res.add(List.of(newR, c));
        if (c+1 == triangle.get(newR).size()) return res;
        res.add(List.of(newR, c+1));

        return res;
    }
}
