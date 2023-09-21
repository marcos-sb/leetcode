import java.util.*;

public class MaximizeCapital {
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) { // O((k+N) * log(N))
        final var N = capitals.length;
        final var minCapitalsI = new PriorityQueue<Integer>((a,b) -> Integer.compare(capitals[a], capitals[b]));
        for (var i = 0; i < N; i++) minCapitalsI.offer(i); // O(N * log(N))
		final var maxProfitsI = new PriorityQueue<Integer>((a,b) -> Integer.compare(profits[b], profits[a]));

        while (0 < k--) { // O(k * log(N))
            while (!minCapitalsI.isEmpty() && capitals[minCapitalsI.peek()] <= c) {
				maxProfitsI.offer(minCapitalsI.poll());
            }
			if (maxProfitsI.isEmpty()) break;
            c += profits[maxProfitsI.poll()]; // O(log(N))
        }

        return c;
    }
}

