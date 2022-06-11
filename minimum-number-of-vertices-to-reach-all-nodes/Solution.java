class Solution {
    static class UF {
        final int[] _id;
        
        UF(int size) {
            _id = new int[size];
            for (var i = 0; i < _id.length; i++)
                _id[i] = i;
        }
        
        int find(int id) {
            while (id != _id[id]) {
                _id[id] = _id[_id[id]];
                id = _id[id];
            }
            return id;
        }
        
        void union(int a, int b) {
            final var ida = find(a);
            final var idb = find(b);
            _id[idb] = ida;
        }
        
        @Override
        public String toString() {
            return Arrays.toString(_id);
        }
    }
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        final var uf = new UF(n);
        for (var e : edges) {
            final var u = e.get(0);
            final var v = e.get(1);
            if (uf.find(v) == v) uf.union(u, v);
        }
        
        final var res = new ArrayList<Integer>();
        for (var i = 0; i < n; i++) {
            if (uf.find(i) == i) res.add(i);
        }
        
        return res;
    }
}
