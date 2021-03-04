class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 2) return 0;
        
        final var freqs = new HashMap<Integer, Integer>();
        int currLen = 2;
        int prev = nums[1];
        int diff = nums[0] - prev;
        for (int i = 2; i < nums.length; i++) {
            final int curr = nums[i];
            if (prev - curr == diff) {
                currLen++;
            } else {
                if (currLen > 2)
                    freqs.put(currLen, freqs.getOrDefault(currLen, 0) + 1);
                currLen = 2;
                diff = prev - curr;
            }
            prev = curr;
        }
        if (currLen > 2)
            freqs.put(currLen, freqs.getOrDefault(currLen, 0) + 1);
        
        int totalArith = 0;
        for (var entry : freqs.entrySet()) {
            final var len = entry.getKey();
            final var count = entry.getValue();
            totalArith += count * (len * (len+1) / 2 - (2*len - 1));
        }
        
        return totalArith;
    }
}
