class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        final var N = num.length;
        var c = 0;
        for (var i = N-1; 0 <= i; i--) {
            num[i] += k % 10 + c;
            c = num[i] / 10;
            num[i] %= 10;
            k /= 10;
        }
        
        final var aux = new ArrayList<Integer>();
        while (0 < k || 0 < c) {
            final var sum = k%10 + c;
            aux.add(sum % 10);
            c = sum / 10;
            k /= 10;
        }
        
        final var res = new ArrayList<Integer>();
        for (var i = aux.size()-1; 0 <= i; i--) res.add(aux.get(i));
        for (var n : num) res.add(n);
        
        return res;
    }
}
