package maximum_69_number;

class Solution {
    public int maximum69Number (int num) {
        var _num = num;
        var revNum = _num % 10;
        _num /= 10;
        while (_num > 0) {
            revNum *= 10;
            revNum += _num % 10;
            _num /= 10;
        }
        _num = revNum % 10;
        revNum /= 10;
        boolean changed = false;
        if (_num == 6) {
            _num = 9;
            changed = true;
        }

        while (revNum > 0) {
            _num *= 10;
            var rightMostDigit = revNum % 10;
            if (!changed && rightMostDigit == 6) {
                rightMostDigit = 9;
                changed = true;
            }
            _num += rightMostDigit;
            revNum /= 10;
        }
        return _num;
    }
}