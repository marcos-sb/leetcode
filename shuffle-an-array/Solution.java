import java.util.Random;

public class Solution {

    private final int [] original;
    private final Random rnd;

    public Solution(int[] nums) {
        this.original = nums;
        this.rnd = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        final int [] ret = new int [original.length];
        for(int i = 0; i<ret.length; i++)
            ret[i] = original[i];
        for(int i = 0; i<original.length; i++) {
            final int newPos = rnd.nextInt(original.length);
            final int tmp = ret[i];
            ret[i] = ret[newPos];
            ret[newPos] = tmp;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
