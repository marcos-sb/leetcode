class Solution {
    private static class UnionFind {
        final int[] root;
        UnionFind(int size) {
            root = new int[size];
            for (var i = 0; i < size; ++i)
                root[i] = i;
        }
        boolean union(int a, int b) {
            final var rootA = find(a);
            final var rootB = find(b);
            if (rootA != rootB) {
                root[rootA] = rootB;
                return true;
            }
            return false;
        }
        int find(int a) {
            var rootA = root[a];
            while (root[rootA] != rootA) {
                root[rootA] = root[root[rootA]];
                rootA = root[rootA];
            }
            return rootA;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final var N = accounts.size();
        final var uf = new UnionFind(N);
        final var emailToAccount = new HashMap<String, Integer>();

        for (int acc = 0; acc < N; ++acc) {
            final var account = accounts.get(acc);
            for (String email : account.subList(1, account.size())) {
                if (emailToAccount.containsKey(email)) {
                    uf.union(acc, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, acc);
                }
            }
        }

        final var merged = new HashMap<Integer, Set<String>>();
        for (int acc = 0; acc < N; ++acc) {
            int root = uf.find(acc);
            final var account = accounts.get(acc);
            final var emails = account.subList(1, account.size());
            merged.computeIfAbsent(root, k -> new TreeSet<>()).addAll(emails);
        }

        final List<List<String>> res = new ArrayList<>();
        for (var e : merged.entrySet()) {
            final var mergedAcc = new ArrayList<String>();
            mergedAcc.add(accounts.get(e.getKey()).get(0));
            mergedAcc.addAll(e.getValue());
            res.add(mergedAcc);
        }
        return res;
    }
}
