class SparseVector {
    final Map<Integer, Integer> val;
    
    SparseVector(int[] nums) {
        val = new HashMap<>(nums.length);
        for (var i = 0; i < nums.length; i++)
            if (nums[i] > 0) val.put(i, nums[i]);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        var dp = 0;
        final var smaller = vec.val.size() > this.val.size() ? vec : this;
        final var bigger = vec == smaller ? this : vec;
        for (var entry : smaller.val.entrySet()) {
            if (bigger.val.containsKey(entry.getKey()))
                dp += entry.getValue() * bigger.val.get(entry.getKey());
        }
        return dp;
    }
}
