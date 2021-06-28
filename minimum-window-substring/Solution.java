class Solution {
    public String minWindow(String searchString, String t) {
        final int[] freqs = new int[26];
        for (int i = 0; i < t.length(); i++) {
            freqs[t.charAt(i)-'a']++;
        }

        final int[] clone = Arrays.copyOf(freqs, freqs.length);
        int l = 0;
        int r = 0;
        int windowMatches = 0;
        int minL = -1;
        int minR = -1;

        while (r < searchString.length()) {
            while (r < searchString.length()) {
                final int idx = searchString.charAt(r)-'a';
                if (clone[idx] > 0 && freqs[idx]-- > 0) {
                    windowMatches++;
                    if (windowMatches == t.length()) {
                        if (minR-minL > r-l || minR == -1) {
                            minL = l;
                            minR = r;
                        }
                        break;
                    }
                }
                r++;
            }
            
            while (l < r && windowMatches == t.length()) {
                final int idx = searchString.charAt(l)-'a';
                if (clone[idx] > 0) {
                    freqs[idx]++;
                    if (freqs[idx] > 0) {
                        windowMatches--;
                    }
                }
                if (minR-minL > r-l) {
                    minL = l;
                    minR = r;
                }
                l++;
            }
          
            r++;
        }

        if (minR == -1) return "";

        return searchString.substring(minL, minR+1);
    }
}
