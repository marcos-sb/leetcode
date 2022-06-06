class Solution {
    public int findTheWinner(int n, int k) {
        final var people = new int[n];
        final var _k = k;
        final var _n = n;
        var i = -1;
        while (1 < n--) {
            while (0 < k) {
                i = (i+1) % _n;
                if (people[i] == 0) k--;
            }
            people[i] = -1;
            k = _k;
        }
        
        for (var j = 0; j < _n; j++) {
            if (people[j] == 0) return j+1;
        }
        
        return -1;
    }
}
