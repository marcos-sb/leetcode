class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        final var levels = wall.size();
        final var brickEdges = new HashMap<Integer, Integer>();
        var maxEdgeOverlap = 0;

        for (var level : wall) {
            var brickEdge = 0;
            for (var i = 0; i < level.size()-1; ++i) {
                brickEdge += level.get(i);
                final var edgeOverlap = brickEdges.getOrDefault(brickEdge, 0) + 1;
                maxEdgeOverlap = Math.max(edgeOverlap, maxEdgeOverlap);
                brickEdges.put(brickEdge, edgeOverlap);
            }
        }

        return levels - maxEdgeOverlap;
    }
}
