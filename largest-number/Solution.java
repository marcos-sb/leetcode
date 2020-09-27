class Solution {
    public String largestNumber(int[] nums) {
        final var numsStr = Arrays.stream(nums).boxed()
            .map(String::valueOf)
            .collect(Collectors.toList());
        
        Collections.sort(numsStr, (s,t) -> {
            final var st = s + t;
            final var ts = t + s;
            return ts.compareTo(st); // desc sort
        });
        
        final var sb = new StringBuilder();
        for (var n : numsStr) sb.append(n);
        
        return trimLeading('0', sb).toString();
    }
    
    private static CharSequence trimLeading(char c, CharSequence cs) {
        int i = 0;
        while (i < cs.length()-1 && cs.charAt(i) == c) i++;
        if (i == 0) return cs.toString();
        return cs.subSequence(i, cs.length());
    }
}
