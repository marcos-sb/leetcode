package number_of_steps_to_reduce_a_number_to_zero;

class Solution {
    public int numberOfSteps (int num) {
        var count = 0;
        var _num = num;
        while (_num > 0) {
            if (_num % 2 == 0) _num /= 2;
            else _num -= 1;
            count++;
        }
        return count;
    }
}