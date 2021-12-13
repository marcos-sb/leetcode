class Solution {
    public int[] twoSum(int[] numbers, int target) {
        var l = 0;
        var r = numbers.length-1;

        while (l < r) {
            final var sum = numbers[l] + numbers[r];
            if (sum < target) l++;
            else if (target < sum) r--;
            else return new int[]{l+1,r+1};
        }
        
        return new int[0];
    }
}
