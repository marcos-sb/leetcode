import java.util.TreeSet;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        
        final var map = new TreeMap<Integer, Integer>();
        for (var intval : intervals) {
            var left = intval[0];
            var right = intval[1];
            if (!map.isEmpty()) {
                final var floorLeftEntry = map.floorEntry(left);
                var floorLeft = 0;
                if (floorLeftEntry != null) floorLeft = floorLeftEntry.getKey();
                
                final var floorRightEntry = map.floorEntry(right);
                var floorRight = floorLeft;
                if (floorRightEntry != null) floorRight = floorRightEntry.getKey();
                
                final var submap = map.subMap(floorLeft, true, floorRight, true);
                
                final var it = submap.entrySet().iterator();
                while (it.hasNext()) {
                    final var entry = it.next();
                    if (right < entry.getKey() || entry.getValue() < left) continue;
                    left = Math.min(entry.getKey(), left);
                    right = Math.max(entry.getValue(), right);
                    it.remove();
                }
            }
            map.put(left, right);
        }
        
        final var res = new int[map.size()][];
        int i = 0;
        for (var entry : map.entrySet())
            res[i++] = new int[]{entry.getKey(), entry.getValue()};
        
        return res;
    }
}
