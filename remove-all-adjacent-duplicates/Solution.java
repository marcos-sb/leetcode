class Solution {
    static class IntWrapper {
        int val;
        IntWrapper(int val) { this.val = val; }
    }
    
    public String removeDuplicates(String s, int k) {
        final var st = new LinkedList<IntWrapper>();
        final var sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            final var sbTop = sb.length() == 0 ? ' ' : sb.charAt(sb.length()-1);
            
            if (st.isEmpty() || sbTop != c) st.offerLast(new IntWrapper(1));
            else if (sbTop == c) st.peekLast().val++;
            sb.append(c);
            
            if (st.peekLast().val == k) {
                st.pollLast();
                sb.setLength(sb.length()-k);
            }
        }
        
        return sb.toString();
    }
}
