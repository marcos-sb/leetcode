class Solution {
    public boolean reorderedPowerOf2(int n) {
        final var powers = powersOf2(); // O(len(n) * log n)
        final var s = String.valueOf(n); // O(n)
        final var mapS = string2map(s); // O(n)
        
        if (!powers.containsKey(s.length())) return false;
        
        final var candidates = powers.get(s.length());
        for (var power2 : candidates) {
            if (power2.equals(mapS)) return true;
        }
        
        return false;
    }
    
    private static Map<Integer, List<Map<Character, Integer>>> powersOf2() {
        final Map<Integer, List<Map<Character, Integer>>> res = new HashMap<>();
        for (int i = 1; i <= 1_000_000_000; i *= 2) { // O(s * log n)
            final var s = String.valueOf(i);
            res.computeIfAbsent(s.length(), (k) -> new ArrayList<>())
               .add(string2map(s)); // O(s)
        }
        return res;
    }
    
    private static Map<Character, Integer> string2map(String s) {
        final var res = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) { // O(s)
            final var c = s.charAt(i);
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
        return res;
    }
}
