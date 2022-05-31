class Solution {
    public List<Integer> partitionLabels(String s) {
        final var S = s.length();
        final List<Set<Character>> parts = new ArrayList<>(S);
        for (var i = 0; i < S; i++) {
            final var newPart = s.charAt(i);
            processPart(parts, newPart);
        }
        
        return partLengths(parts, s);
    }
    
    private static void processPart(List<Set<Character>> parts, char newPart) {
        for (var i = parts.size()-1; 0 <= i; i--) {
            final var part = parts.get(i);
            if (part.contains(newPart)) {
                final var merged = parts.remove(parts.size()-1);
                for (var j = parts.size()-1; i <= j; j--)
                    merged.addAll(parts.remove(j));
                parts.add(merged);
                return;
            }
        }
        parts.add(new HashSet<>(List.of(newPart)));
    }
    
    private static List<Integer> partLengths(List<Set<Character>> parts, String s) {
        var j = 0;
        var count = 0;
        final var res = new ArrayList<Integer>(parts.size());
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (parts.get(j).contains(c)) count++;
            else {
                res.add(count);
                count = 1;
                j++;
            }
        }
        res.add(count);
        
        return res;
    }
}
