class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        final List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < 10; i++)
            go(N, K, i, 1, res);
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static void go(int N, int K, int num, int nDigits, List<Integer> res) {
        if (N == nDigits) {
            res.add(num);
            return;
        }
        
        if (num == 0) return;
        
        if (num%10 + K <= 9) {
            final int newDigit = num * 10 + num%10+K;
            go(N, K, newDigit, nDigits+1, res);
        }
        if (K > 0 && num%10 - K >= 0) {
            final int newDigit = num * 10 + num%10-K;
            go(N, K, newDigit, nDigits+1, res);
        }
    }
}
