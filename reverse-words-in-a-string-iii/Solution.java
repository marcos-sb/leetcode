class Solution {
    public String reverseWords(String s) {
        var l = 0;
        var r = 0;
        final var arr = s.toCharArray();
        while (l < s.length()) {
            while (r < s.length() && arr[r] != ' ') r++;
            // r points to the whitespace char after the word
            reverseString(arr, l, r-1);
            r++;
            l = r;
        }
        
        return new String(arr);
    }
    
    public void reverseString(char[] arr, int l, int r) {
        var i = l;
        var j = r;
        while (i < j) {
            final var tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
    }
}
