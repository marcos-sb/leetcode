public class Solution {
    public String countAndSay(int n) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        
        while (--n > 0) {
            final List<Integer> newL = new ArrayList<>();
            int prev = l.get(0);
            int len = 1;
            for (int i = 1; i < l.size(); i++) {
                final int curr = l.get(i);
                if (prev == curr) len++;
                else {
                    newL.add(len);
                    newL.add(prev);
                    len = 1;
                }
                prev = curr;
            }
            newL.add(len);
            newL.add(prev);
            l = newL;
        }

        final StringBuilder sb = new StringBuilder();
        for (int m : l) sb.append(m);
        
        return sb.toString();
    }
}
