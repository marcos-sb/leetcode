class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        final var capacityChange = new int[1001];
        for (var t : trips) {
            capacityChange[t[1]] += t[0];
            capacityChange[t[2]] -= t[0];
        }
        var _capacityLeft = capacity;
        for (var cc : capacityChange) {
            _capacityLeft -= cc;
            if (_capacityLeft < 0) return false;
        }
        return true;
    }
}
