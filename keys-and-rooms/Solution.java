class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final var foundKey = new boolean[rooms.size()];
        final var q = new ArrayDeque<Integer>();
        q.offerLast(0);
        foundKey[0] = true;
        
        int visitedRooms = 0;
        while (!q.isEmpty()) {
            final var currRoom = q.pollFirst();
            final var currKeys = rooms.get(currRoom);
            visitedRooms++;
            
            for (var key : currKeys) {
                if (foundKey[key]) continue;
                q.offerLast(key);
                foundKey[key] = true;
            }
        }
        
        return visitedRooms == rooms.size();
    }
}
