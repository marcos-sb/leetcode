class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            final int tryH = citations.length - i;
            if (tryH <= citations[i]) return tryH;
        }
        
        return 0;
    }
}
