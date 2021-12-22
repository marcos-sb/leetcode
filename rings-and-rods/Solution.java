class Solution {
    public int countPoints(String rings) {
        if (rings == null) return 0;
        
        final var map = new HashMap<Integer, Set<Character>>();
        for (var i = 0; i < rings.length(); i+=2) {
            final var color = rings.charAt(i);
            final var indx = rings.charAt(i+1)-'0';
            map.computeIfAbsent(indx, k -> new HashSet<>()).add(color);
        }
        
        var fullPos = 0;
        for (var colorSet : map.values())
            if (colorSet.size() == 3) fullPos++;
        
        return fullPos;
    }
}
