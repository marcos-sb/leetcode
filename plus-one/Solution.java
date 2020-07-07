class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length-1;
        while (carry > 0 && i >= 0) {
            if (digits[i] < 9) {
                digits[i]+=carry;
                carry = 0;
            } else digits[i] = 0;
            i--;
        }
        if (carry > 0) {
            final int[] newDigits = new int[digits.length+1];
            System.arraycopy(digits,0,newDigits,1,digits.length);
            newDigits[0] = carry;
            digits = newDigits;
        }
        return digits;
    }
}
