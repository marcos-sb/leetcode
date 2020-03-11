package generate_a_string_with_characters_that_have_odd_counts;

class Solution {
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            return "a".repeat(n-1) + "b";
        }
        return "a".repeat(n);
    }
}
