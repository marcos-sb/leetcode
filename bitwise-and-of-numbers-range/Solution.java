class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        var shifts = 0;
        while (left != right) {
            left >>>= 1;
            right >>>= 1;
            ++shifts;
        }
        return right << shifts;
    }
}
