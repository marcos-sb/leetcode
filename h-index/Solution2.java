class Solution {
    public int hIndex(int[] citations) {
        final int[] higherEqThan = new int[1001];
        int higher1k = 0;
        for (int c : citations) {
            if (c > 1000) higher1k++;
            else higherEqThan[c]++;
        }
        higherEqThan[higherEqThan.length-1] += higher1k;
        for (int i = higherEqThan.length-2; i >= 0; i--) {
            higherEqThan[i] += higherEqThan[i+1];
        }
        
        int i = 1;
        while (i < higherEqThan.length && i <= higherEqThan[i]) { i++; }
        
        return i-1;
    }
}
