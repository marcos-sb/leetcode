class Solution {
    public String removeStars(String s) {
        final var stack = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.setLength(stack.length()-1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
