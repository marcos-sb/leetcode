class Solution {
    public String removeDuplicateLetters(String s) {
        final var counts = new int[26];
        final var sCharArray = s.toCharArray();
        for (var c : sCharArray) {
            counts[c-'a']++;
        }
        final var stack = new StringBuilder();
        final var inStack = new boolean[26];
        for (var c : sCharArray) {
            counts[c-'a']--;
            if (inStack[c-'a']) continue;
            while (!stack.isEmpty() && c < stack.charAt(stack.length()-1) && 0 < counts[stack.charAt(stack.length()-1) - 'a']) {
                inStack[stack.charAt(stack.length()-1)-'a'] = false;
                stack.setLength(stack.length()-1);
            }
            stack.append(c);
            inStack[c-'a'] = true;
        }
        return stack.toString();
    }
}
