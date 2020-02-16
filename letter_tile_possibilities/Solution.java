package letter_tile_possibilities;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numTilePossibilities(String tiles) {
        return perms(new StringBuilder(tiles)).size();
    }
    private static Set<String> perms(StringBuilder s) {
        if (s.length() <= 1) return Set.of(s.toString());
        final var newPerms = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            final var head = s.charAt(i);
            s.deleteCharAt(i);
            for (var ss : perms(s)) {
                newPerms.add(String.valueOf(head));
                newPerms.add(ss);
                newPerms.add(head + ss);
            }
            s.insert(i,head);
        }
        return newPerms;
    }
}
