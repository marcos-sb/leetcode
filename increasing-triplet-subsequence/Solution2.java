class Solution {
    public boolean increasingTriplet(int[] nums) {
        var numi = Integer.MAX_VALUE;
        var numj = Integer.MAX_VALUE;
        for (var n : nums) {
            if (n <= numi) numi = n;
            else if (n <= numj) numj = n;
            else return true;
        }
        return false;
    }
}
