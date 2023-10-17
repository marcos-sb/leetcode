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

        for (var j = i; j < nums.size(); j++) {
            final var num = nums.get(j);
            if (target - num < 0) continue;
            curr.add(num);
            bt(j+1, nums, target-num, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
