class Solution3 {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    if (rooms.isEmpty()) return true;
    
    final var seen = new boolean[rooms.size()];
    final var q = new LinkedList<Integer>();
    q.offer(0);
    var opened = 0;
    while (!q.isEmpty()) {
      final var currRoom = q.poll();
      seen[currRoom] = true;
      opened++;
      for (var room : rooms.get(currRoom)) {
        if (seen[room]) continue;
        q.offer(room);
        seen[room] = true;
      }
    }

    return opened == rooms.size();
  }
}
