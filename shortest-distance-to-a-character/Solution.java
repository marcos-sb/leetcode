class Solution {
    public int[] shortestToChar(String s, char c) {
        final List<Integer> posC = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) posC.add(i);
        }
        
        final int[] res = new int[s.length()];
        int j = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            final int dist = Math.abs(posC.get(k) - i);
            if (k < posC.size()-1 && posC.get(k+1) - i <= dist) {
                res[j] = posC.get(k+1) - i;
                k++;
            } else {
                res[j] = dist;
            }
            j++;
        }
        
        return res;
    }
}
