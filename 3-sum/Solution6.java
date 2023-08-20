import java.util.Arrays;

public class SumOfThree{
   public static boolean findSumOfThree(int[] nums, int target) {
      Arrays.sort(nums);
      final var N = nums.length;
      var i = N-3;
      while (0 <= i) {
         var l = i+1;
         var r = N-1;
         while (l < r) {
            if (nums[i] + nums[l] + nums[r] == target) return true;
            if (nums[i] + nums[l] + nums[r] < target) l++;
            else r--;
         }
         i--;
      }
      return false;
   }
}
