class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 1) return Collections.singletonList(1);
        
        int[] prev = new int[rowIndex+1];
        int[] curr = new int[rowIndex+1];
        
        curr[0] = 1;
        curr[1] = 1;
        for (int r = 2; r <= rowIndex; r++) {
            final int[] tmp = prev;
            prev = curr;
            curr = tmp;
            
            curr[0] = 1;
            for (int i = 1; i < r; i++) {
                curr[i] = prev[i-1] + prev[i];
            }
            curr[r] = 1;
        }
        
        return Arrays.stream(curr).boxed().collect(Collectors.toList());
    }
}
