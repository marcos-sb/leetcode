class Solution {
    public String addBinary(String a, String b) {
        final var A = a.length();
        final var B = b.length();
        final var res = new StringBuilder(A+B);
        var i = A-1;
        var j = B-1;
        var c = 0;
        while (0 <= i || 0 <= j) {
            final var opa = 0 <= i ? a.charAt(i--)-'0' : 0;
            final var opb = 0 <= j ? b.charAt(j--)-'0' : 0;
            final var sum = opa + opb + c;
            c = sum / 2;
            res.append(sum % 2);
        }
        if (0 < c) res.append(c);
        
        return res.reverse().toString();
    }
}
