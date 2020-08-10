class Solution {
    public int titleToNumber(String s) {
        int abc_len = 'Z' - 'A' + 1;
        
        int sum = s.charAt(0) - 'A' + 1;
        for (int i = 1; i < s.length(); i++) {
            sum *= abc_len;
            sum +=  s.charAt(i) - 'A' + 1;
        }
        
        return sum;
    }
}
