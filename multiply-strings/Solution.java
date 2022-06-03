class Solution {
    public String multiply(String num1, String num2) {
        final var n1 = toIntArray(num1);
        final var n2 = toIntArray(num2);
        final var L1 = n1.length;
        final var L2 = n2.length;
        
        var carry = 0;
        final var res = new int[L1+L2];
        var k = 0;
        for (var j = L2-1; 0 <= j; j--) {
            carry = 0;
            final var aux = new ArrayList<Integer>(L1+1);
            for (var i = L1-1; 0 <= i; i--) {
                final var mult = n2[j] * n1[i] + carry;
                aux.add(mult % 10);
                carry = mult / 10;
            }
            if (0 < carry) aux.add(carry);
            
            carry = 0;
            for (var i = 0; i < aux.size(); i++) {
                final var sum = res[i+k] + aux.get(i) + carry;
                res[i+k] = sum % 10;
                carry = sum / 10;
            }
            if (0 < carry) res[aux.size()+k] = carry;
            k++;
        }
        
        var p = 0;
        for (var i = L1+L2-1; 0 <= i; i--)
            if (res[i] != 0) {
                p = i; break;
            }
        final var sb = new StringBuilder(L1+L2);
        for (var i = p; 0 <= i; i--)
            sb.append(res[i]);
        
        return sb.toString();
    }
    
    private static int[] toIntArray(String s) {
        final var res = new int[s.length()];
        for (var i = 0; i < s.length(); i++)
            res[i] = s.charAt(i) - '0';
        return res;
    }
}
