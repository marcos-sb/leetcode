class Solution {
    public String convert(String s, int rows) {
        if (rows < 2) return s;
        
        final var sbs = new StringBuilder[rows];
        for (var i = 0; i < sbs.length; i++)
            sbs[i] = new StringBuilder();

        var k = 0;
        var kdelta = 1;
        for (var i = 0; i < s.length(); i++) {
            sbs[k].append(s.charAt(i));
            k += kdelta;
            if (k < 0) {
                k = 1;
                kdelta = 1;
            } else if (k == rows) {
                k = rows-2;
                kdelta = -1;
            }
        }

        final var res = new StringBuilder();
        for (var sb : sbs)
            for (var i = 0; i < sb.length(); i++)
                res.append(sb.charAt(i));

        return res.toString();
    }
}
