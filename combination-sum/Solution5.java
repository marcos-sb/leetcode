class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<List<Integer>>> dp = new ArrayList<>(target+1);
        dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());

        for (var i = 1; i <= target; i++) { // [3]: O(target) * [2] => O(target*N*l^2*log(l))
            dp.add(new ArrayList<>());
            for (var c : candidates) { // [2]: O(N) * [1]
                if (i < c) continue;
                final var prev = dp.get(i-c);
                if (prev.isEmpty()) continue;

                final var curr = dp.get(i);
                for (var l : prev) { // [1]: O(l) * O(l*log(l)) => O(l^2*log(l)), l = target/min
                    final var newL = new ArrayList<>(l);
                    newL.add(c);
                    Collections.sort(newL); // O(l*log(l))
                    if (!curr.contains(newL)) curr.add(newL);
                }
            }
        }

        return dp.get(target);
    }
}
