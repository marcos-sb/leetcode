class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        final var ret = cb(k, 1, n, new ArrayList<>(){{add(new ArrayList<>());}});
        ret.remove(ret.size()-1);
        return ret;
    }

    private static List<List<Integer>> cb(int k, int i, int n, List<List<Integer>> combs) {
        if (n < 0) return combs;

        if (k == 0) {
            if (n == 0) {
                final var last = combs.get(combs.size()-1);
                combs.add(new ArrayList<>(last));
            }
            return combs;
        }

        int j = i;
        while (j <= 9) {
            combs.get(combs.size()-1).add(j);
            cb(k-1, j+1, n-j, combs);
            final var last = combs.get(combs.size()-1);
            last.remove(last.size()-1);
            j++;
        } 

        return combs;
    }
}
