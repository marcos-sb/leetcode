class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final var ewi = wordList.indexOf(endWord);
        if (ewi < 0) return 0;

        var bwi = wordList.indexOf(beginWord);
        if (bwi < 0) {
            bwi = wordList.size();
            wordList.add(beginWord);
        }
        final var N = wordList.size();
        final List<Integer>[] wg = new ArrayList[N];
        for (var i = 0; i < N; i++)
            wg[i] = new ArrayList<>();

        for (var i = 0; i < N-1; i++) {
            for (var j = i+1; j < N; j++) {
                final var w1 = wordList.get(i);
                final var w2 = wordList.get(j);
                if (d1(w1, w2)) {
                    wg[i].add(j);
                    wg[j].add(i);
                }
            }
        }

        final var q = new LinkedList<Integer>();
        final var seen = new boolean[N];
        q.offer(bwi);
        seen[bwi] = true;
        var dist = 1;
        while (!q.isEmpty()) {
            var qSize = q.size();
            while (0 < qSize--) {
                final var curri = q.poll();
                if (curri == ewi) return dist;
                for (var wi : wg[curri]) if (!seen[wi]) {
                    seen[wi] = true;
                    q.offer(wi);
                }
            }
            dist++;
        }
        
        return 0;
    }

    private static boolean d1(String w1, String w2) {
        var dist = 0;
        final var len = w1.length();
        for (var i = 0; i < len; i++)
            if (w1.charAt(i) != w2.charAt(i) && 1 < ++dist)
                return false;
        return true;
    }
}
