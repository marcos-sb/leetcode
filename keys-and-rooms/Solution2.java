class Solution2 {
    private int visited = 0;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final var foundKey = new boolean[rooms.size()];
        foundKey[0] = true;
        return cvar(rooms, 0, foundKey);
    }
    
    private boolean cvar(List<List<Integer>> rooms, int room, boolean[] foundKey) {
        visited++;
        if (visited == rooms.size()) return true;
        
        final var keys = rooms.get(room);
        for (var key : keys) {
            if (foundKey[key]) continue;
            foundKey[key] = true;
            if (cvar(rooms, key, foundKey)) return true;
        }
        
        return false;
    }
}
