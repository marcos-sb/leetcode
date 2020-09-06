class Solution {
    public List<Integer> partitionLabels(String S) {
        final Map<Character, Integer> char2pos = new HashMap<>();
        for (int i = 0; i < S.length(); i++)
            char2pos.put(S.charAt(i), i);
        
        int i = 0;
        final List<Integer> res = new ArrayList<>();
        while (i < S.length()) {
            final int[] interval = new int[]{i, char2pos.get(S.charAt(i))};
            for (int j = i+1; j < interval[1]; j++) {
                final int jpos = char2pos.get(S.charAt(j));
                interval[1] = Math.max(interval[1], jpos);
            }
            res.add(interval[1]-interval[0]+1);
            i = interval[1]+1;
        }
        
        return res;
    }
}
