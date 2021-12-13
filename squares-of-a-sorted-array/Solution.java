class Solution {
    public int[] sortedSquares(int[] nums) {
        final var negatives = new ArrayList<Integer>(nums.length);
        final var positives = new ArrayList<Integer>(nums.length);
        for (var n : nums) {
            if (n < 0) negatives.add(n*n);
            else positives.add(n*n);
        }
        
        var i = negatives.size()-1;
        var j = 0;
        final var ret = new int[negatives.size()+positives.size()];
        for (int k = 0; k < ret.length; k++) {
            if (i < 0)
                ret[k] = positives.get(j++);
            else if (j >= positives.size())
                ret[k] = negatives.get(i--);
            else if (positives.get(j) <= negatives.get(i))
                ret[k] = positives.get(j++);
            else
                ret[k] = negatives.get(i--);
        }
        
        return ret;
    }
}
