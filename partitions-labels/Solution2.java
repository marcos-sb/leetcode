public class Solution {
    public List<Integer> partitionLabels(String S) {
        final int[] rightMostI = new int['z'-'a'+1];
        for (int i = 0; i < S.length(); i++)
            rightMostI[S.charAt(i)-'a'] = i;
        
        int r = 0;
        int len = 0;
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            len++;
            r = Math.max(r, rightMostI[S.charAt(i)-'a']);
            if (r == i) {
                res.add(len);
                len = 0;
            }
        }

        return res;
    }
}
