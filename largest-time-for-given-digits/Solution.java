import java.util.Collection;

class Solution {
    public String largestTimeFromDigits(int[] A) {
        return perms(A)
            .filter(Solution::validTime)
            .max(Comparator.naturalOrder())
            .map(t -> String.format("%c%c:%c%c", t.charAt(0), t.charAt(1), t.charAt(2), t.charAt(3)))
            .orElse("");
    }
    
    private static Stream<String> perms(int[] A) {
        if (A.length == 0) return Stream.of();
        if (A.length == 1) return Stream.of(String.valueOf(A[0]));
        
        final Queue<StringBuilder> q = new LinkedList<>();
        q.add(new StringBuilder(String.valueOf(A[0])));
        for (int i = 1; i < A.length; i++) {
            var qsize = q.size();
            while (qsize-- > 0) {
                final var el = q.poll();
                for (int j = 0; j <= el.length(); j++)
                    q.add(new StringBuilder(el).insert(j,A[i]));
            }
        }

        return q.stream().map(StringBuilder::toString);
    }
    
    private static boolean validTime(String time) {
        final var h = time.charAt(0);
        final var hh = time.charAt(1);
        final var m = time.charAt(2);
        final var s = time.charAt(3);
        return
            (h == '2' && hh <= '3' || h <= '1') && m <= '5';
    }
}
