class Solution {
    public List<String> fizzBuzz(int n) {
        final var res = new ArrayList<String>(n);
        for (var i = 1; i <= n; ++i) {
            res.add(_fizzBuzz(i));
        }
        return res;
    }

    private static String _fizzBuzz(int n) {
        if (n % 15 == 0) return "FizzBuzz";
        if (n % 5 == 0) return "Buzz";
        if (n % 3 == 0) return "Fizz";
        return String.valueOf(n);
    }
}
