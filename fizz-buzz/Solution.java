class Solution {
    public List<String> fizzBuzz(int n) {
        final var res = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            final var mult3 = i % 3 == 0;
            final var mult5 = i % 5 == 0;
            if (mult3 && mult5) res.add("FizzBuzz");
            else if (mult3) res.add("Fizz");
            else if (mult5) res.add("Buzz");
            else res.add(Integer.toString(i));
        }
        return res;
    }
}
