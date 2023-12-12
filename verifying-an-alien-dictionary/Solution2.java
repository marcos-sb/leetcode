class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        final var orderIdx = new int['z'-'a'+1];
        for (var i = 0; i < order.length(); i++) {
            final var c = order.charAt(i);
            orderIdx[c-'a'] = i;
        }

        final var N = words.length;
        for (var i = N-1; 0 < i; i--) {
            final var w = words[i-1];
            final var s = words[i];
            final var W = w.length();
            final var S = s.length();
            if (S < W && w.startsWith(s)) return false;
            final var shortest = Math.min(W, S);
            for (var j = 0; j < shortest; j++) {
                final var wc = w.charAt(j);
                final var sc = s.charAt(j);
                if (wc == sc) continue;
                if (orderIdx[sc-'a'] < orderIdx[wc-'a']) return false;
                break;
            }
        }

        return true;
    }
}
