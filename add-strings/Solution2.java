class Solution {
    public String addStrings(String num1, String num2) {
        final var res = new char[Math.max(num1.length(),num2.length()) + 1];
        var carry = 0;
        var k = res.length-1;
        var i = num1.length()-1;
        var j = num2.length()-1;
        while (0 <= i || 0 <= j) {
            final var n1 = 0 <= i ? num1.charAt(i)-'0' : 0;
            final var n2 = 0 <= j ? num2.charAt(j)-'0' : 0;
            final var tmp = carry + n1 + n2;
            res[k--] = (char) ((tmp % 10) + '0');
            carry = tmp / 10;
            i--;
            j--;
        }
        
        if (carry != 0) {
            res[0] = (char) (carry + '0');
            return new String(res);
        }
        return new String(res, 1, res.length-1);
    }
}
