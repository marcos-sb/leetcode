class Solution {
    public String multiply(String num1, String num2) {
        final var N1 = num1.length();
        final var N2 = num2.length();
        final var M = N1 + N2;
        final var mul = new int[M];
        for (var i = N1-1; 0 <= i; i--) {
            for (var j = N2-1; 0 <= j; j--) {
                final var op1 = num1.charAt(i)-'0';
                final var op2 = num2.charAt(j)-'0';
                final var k = i+j+1;
                final var prod = op1*op2 + mul[k];
                mul[k-1] += prod / 10;
                mul[k] = prod % 10;
            }
        }

        final var res = new StringBuilder();
        var leading = true;
        for (var n : mul)
            if (0 == n && leading) continue;
            else {
                leading = false;
                res.append(n);
            }
        return res.isEmpty() ? "0" : res.toString();
    }
}
