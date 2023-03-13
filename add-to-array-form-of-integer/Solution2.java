class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        var N = num.length;
        final var res = new LinkedList<Integer>();
        while (0 <= --N || 0 < k) {
            k += 0 <= N ? num[N] : 0;
            res.addFirst(k%10);
            k /= 10;
        }
        return res;
    }
}
