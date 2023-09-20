import java.util.*;

public class Solution {
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        final var N = capitals.length;
        final Comparator<Integer> cmp = (a, b) -> Integer.compare(capitals[a], capitals[b]);
        final var minCapitalsI = new PriorityQueue<Integer>(cmp);
        for (var i = 0; i < N; i++) minCapitalsI.offer(i); // N * log(N)
        final var investableProjectsI = new ArrayList<Integer>();

        while (0 < k-- && !minCapitalsI.isEmpty()) { // N^2 * log(N)
            var maxProfitI = -1;
            while (!minCapitalsI.isEmpty() && capitals[minCapitalsI.peek()] <= c) { // N * log(N)
                final var minI = minCapitalsI.poll(); // log(N)
                investableProjectsI.add(minI);
                if (maxProfitI == -1 || profits[maxProfitI] < profits[minI])
                    maxProfitI = minI;
            }
            if (maxProfitI == -1) break;
            c += profits[maxProfitI];
            for (var i : investableProjectsI) // N * log(N)
                if (maxProfitI != i) minCapitalsI.offer(i); // log(N)
            investableProjectsI.clear(); // O(1)
        }

        return c;
    }
}

