class Solution {
    public void sortColors(int[] nums) {
        var N = nums.length;
        var i = 0;
        var j = N-1;
        
        while (i < j) {
            while (i < j && nums[i] == 0) i++;
            while (i < j && nums[j] == 2) j--;
            if (i == j) break;
            if (nums[i] == nums[j]) { // 1 == 1
                var k = i+1;
                while (k < j && nums[k] == 1) k++;
                if (k == j) break;
                if (nums[k] == 0) swap(i, k, nums);
                else swap(j, k, nums);
            } else swap(i, j, nums);
        }
    }
    
    private static void swap(int i, int j, int[] nums) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
