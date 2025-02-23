class Solution {
    public int[] twoSum(int[] numbers, int target) {
        var l = 0;
        var r = numbers.length-1;
        while (l < r) {
            final var sum = numbers[l] + numbers[r];
            if (target < sum) r--;
            else if (sum < target) l++;
            else return new int[]{l+1, r+1};
        }
        return new int[]{-1, -1};
    }
}
