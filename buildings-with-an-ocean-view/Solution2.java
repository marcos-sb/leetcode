class Solution {
    public int[] findBuildings(int[] h) {
        final var n = h.length;
        final var aux = new ArrayList<Integer>(n);

        var maxHeight = h[n-1];
        aux.add(n-1);
        for (var i = n-2; 0 <= i; --i) {
            if (h[i] <= maxHeight) continue;
            maxHeight = h[i];
            aux.add(i);
        }

        final var m = aux.size();
        final var res = new int[m];
        var k = 0;
        for (var i = m-1; 0 <= i; --i)
            res[k++] = aux.get(i);

        return res;
    }
}
