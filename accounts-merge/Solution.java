class Solution {
    static class UnionFind {
        final int[] index;
        UnionFind(int size) {
            index = new int[size];
            for (var i = 0; i < size; i++) {
                index[i] = i;
            }
        }
        int find(int a) {
            while (index[a] != a) {
                index[a] = index[index[a]];
                a = index[a];
            }
            return a;
        }
        void union(int a, int b) {
            final var ka = find(a);
            final var kb = find(b);
            index[ka] = kb;
        }
        @Override
        public String toString() {
            return Arrays.toString(index);
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final var email2idx = new HashMap<String, List<Integer>>(accounts.size());
        for (var i = 0; i < accounts.size(); i++) {
            final var info = accounts.get(i);
            final var name = info.get(0);
            final var emails = info.subList(1, info.size());
            for (var email : emails) {
                email2idx.computeIfAbsent(email, k -> new ArrayList<>())
                         .add(i);
            }
        }
        
        final var uf = new UnionFind(accounts.size());
        for (var indices : email2idx.values()) {
            var klass = -1;
            for (var idx : indices) {
                if (klass == -1) klass = idx;
                else {
                    uf.union(klass, idx);
                }
            }
        }
        
        final var klass2emails = new HashMap<Integer, Set<String>>(accounts.size());
        for (var i = 0; i < accounts.size(); i++) {
            final var info = accounts.get(i);
            final var klass = uf.find(i);
            klass2emails.computeIfAbsent(klass, k -> new HashSet<>())
                      .addAll(info.subList(1, info.size()));
        }
        
        final List<List<String>> res = new ArrayList<>();
        for (var entry : klass2emails.entrySet()) {
            final var name = accounts.get(entry.getKey()).get(0);
            final var allEmails = new ArrayList<>(entry.getValue());
            Collections.sort(allEmails);
            final var mergedAccount = new ArrayList<String>();
            mergedAccount.add(name);
            mergedAccount.addAll(allEmails);
            res.add(mergedAccount);
        }
        
        return res;
    }
}
