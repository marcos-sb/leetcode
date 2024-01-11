class Solution {
    // The fundamental idea behind this solution lies in the following reasoning:
    // if room A and B are connected and they are also connected with
    // room C, then it follows that there's a cycle A->C->B->A of length 3.
    //
    // The trick with this approach is that you have to check for a common
    // room every time you process a corridor, as that's what connects
    // the two rooms at each end of the corridor.
    //
    // Corridors are never repeated in the input, that guarantees we're only
    // counting common rooms once with this approach.
    //
    // The order in which we process the corridors doesn't matter. This is because
    // any ordering of the rooms in a cyclic path will not make it a different
    // cycle, nor will it make go uncounted. For example: the cycle A-C-B,
    // made up of corridors A-C, C-B and B-A can be found with any ordering of
    // those corridors, only the starting (and ending) room of the cycle would
    // change.
    public int numberOfPaths(int n, int[][] corridors) {
        final Set<Integer>[] graph = new Set[n];
        for (var i = 0; i < n; i++) graph[i] = new HashSet<>();
        
        var count = 0;
        for (var c : corridors) { // O(c*n), for complete graphs
            graph[c[0]-1].add(c[1]-1);
            graph[c[1]-1].add(c[0]-1);
            count += intersectSize(graph[c[0]-1], graph[c[1]-1]); // O(n), for complete graphs
        }

        return count;
    }

    private static <T> int intersectSize(Set<T> set1, Set<T> set2) { // assuming hashsets: O(min(len(set1),len(set2)))
        final var smaller = set1.size() <= set2.size() ? set1 : set2;
        final var bigger = smaller == set1 ? set2 : set1;
        var size = 0;
        for (var el : smaller)
            if (bigger.contains(el)) size++;
        return size;
    }
}
