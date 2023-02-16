class Solution {
    public boolean backspaceCompare(String s, String t) {
        final var N = s.length();
        final var M = t.length();
        var i = N-1;
        var j = M-1;
        if (s.charAt(i) == '#') i = movePointer(s, i);
        if (t.charAt(j) == '#') j = movePointer(t, j);
        while (true) {
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if (s.charAt(i) != t.charAt(j)) return false;
            i = movePointer(s, i);
            j = movePointer(t, j);
        }
    }
    
    private static int movePointer(String s, int i) {
        if (i < 0) return i;
        
        var skip = 0;
        if (s.charAt(i--) == '#') skip = 1;
        while (0 <= i && (0 < skip || s.charAt(i) == '#')) {
            if (s.charAt(i--) == '#') skip++;
            else skip--;
        }
        
        return i;
    }
}
