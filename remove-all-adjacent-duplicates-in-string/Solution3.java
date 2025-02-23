class Solution {
    public String removeDuplicates(String s) {
        final var stack = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.charAt(stack.length()-1) == c) {
                stack.setLength(stack.length()-1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
