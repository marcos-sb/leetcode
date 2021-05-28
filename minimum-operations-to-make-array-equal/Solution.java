class Solution {
    public int minOperations(int n) {
        if (n % 2 == 0)
            return (int)(n/2/2d * (2 + (n/2 - 1)*2));
        return (int)(n/2/2d * (4 + (n/2 - 1)*2));
    }
}
