class CombinationIterator {
    private final String input;
    private final int len;
    private final StringBuilder sb;
    private final Map<Character, Integer> char2idx;
    
    public CombinationIterator(String characters, int combinationLength) {
        input = characters;
        len = combinationLength;
        
        sb = new StringBuilder();
        for (int j = 0; j < len; j++) {
            sb.append(input.charAt(j));
        }
        
        char2idx = new HashMap<>(input.length());
        for (int j = 0; j < input.length(); j++) {
            char2idx.put(input.charAt(j), j);
        }
    }
    
    public String next() {
        final String next = sb.toString();
        if (next.isEmpty()) return null;
        
        int i;
        do {
            i = char2idx.get(sb.charAt(sb.length()-1)) + 1;
            sb.setLength(sb.length()-1);
        } while (sb.length() + input.length() - i < len && sb.length() > 0);
        
        if (sb.length() + input.length() - i < len) {
            sb.setLength(0);
            return next;
        }
        
        while (sb.length() < len && i < input.length()) {
            sb.append(input.charAt(i++));
        }
        
        return next;
    }
    
    public boolean hasNext() {
        return sb.length() != 0;
    }
}
