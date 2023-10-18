import java.util.*;

public class Main {
    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        // final var N = setOfIntegers.size();
        final List<List<Integer>> res = new ArrayList<>();
        bt(0, setOfIntegers, targetSum, new ArrayList<Integer>(), res);
        return res;
    }

    private static void bt(int i, List<Integer> nums, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if (i == nums.size()) return;

        final var num = nums.get(i);
        if (0 <= target-num) {
            curr.add(num);
            bt(i+1, nums, target-num, curr, res);
            curr.remove(curr.size()-1);
        }
        bt(i+1, nums, target, curr, res);
    }
}
