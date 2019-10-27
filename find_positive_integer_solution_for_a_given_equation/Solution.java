package find_positive_integer_solution_for_a_given_equation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    interface CustomFunction {
        int f(int x, int y);
    }
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        final List<List<Integer>> roots = new ArrayList<>();
        for (int _x = 1; customfunction.f(_x,1) <= z; _x++) {
            for (int _y = 1;; _y++) {
                final int fxy = customfunction.f(_x,_y);
                if (fxy > z) break;
                if (fxy == z) roots.add(Arrays.asList(_x,_y));
            }
        }
        return roots;
    }
}
