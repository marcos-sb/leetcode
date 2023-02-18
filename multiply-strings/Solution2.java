class Solution {
    public String multiply(String num1, String num2) {
        if (isZero(num1) || isZero(num2)) return "0";
        final var len1 = num1.length();
        final var len2 = num2.length();
        final var res = new StringBuilder();
        for (var i = len1-1; 0 <= i; i--) {
            final var c = num1.charAt(i);
            final var sb = mul(c, num2);
            sum(res, sb, len1-1-i);
        }
        return res.reverse().toString();
    }

    private static boolean isZero(String s) {
        return s.length() == 1 && s.charAt(0) == '0';
    }

    private static StringBuilder mul(char c, String s) {
        final var sb = new StringBuilder();
        var carry = 0;
        for (var i = s.length()-1; 0 <= i; i--) {
            var n = (c-'0') * (s.charAt(i)-'0') + carry;
            sb.append(n%10);
            carry = n/10;
        }
        if (0 < carry) sb.append(carry);
        return sb;
    }

    private static void sum(StringBuilder sb1, StringBuilder sb2, int shift) {
        var i = shift;
        var j = 0;
        var carry = 0;
        while (i < sb1.length() && j < sb2.length()) {
            final var n = sb1.charAt(i)-'0' + sb2.charAt(j)-'0' + carry;
            sb1.setCharAt(i, Character.forDigit(n%10, 10));
            carry = n/10;
            i++; j++;
        }
        while (j < sb2.length()) {
            final var n = sb2.charAt(j)-'0' + carry;
            sb1.append(n%10);
            carry = n/10;
            j++;
        }
        if (0 < carry) sb1.append(carry);
    }
}
