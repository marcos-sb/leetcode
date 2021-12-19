class Solution {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> ret = new ArrayList<>();
        aux(n, k, 1, new ArrayList<>(), ret);
        return ret;
    }
    
    private static void aux(int n, int k, int i, List<Integer> aux, List<List<Integer>> ret) {
        if (aux.size() == k) {
            ret.add(new ArrayList<>(aux)); // O(k)
            return;
        }

        for (var j = i; j <= n; j++) {
            aux.add(j);
            aux(n, k, j+1, aux, ret);
            aux.remove(aux.size()-1);
        }
    }
}
