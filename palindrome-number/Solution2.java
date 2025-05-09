class Solution {
    public boolean isPalindrome(int x) {
        var _x = x;
        var revX = 0;
        while (0 < _x) {
            revX = revX * 10 + _x % 10;
            _x /= 10;
        }
        return revX == x;
    }
}
