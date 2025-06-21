class Solution {
    private static class Node {
        Node[] next;
        boolean terminal;
        public Node() {
            this.next = new Node[26];
            this.terminal = false;
        }
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);

        final var trieHead = new Node();
        var maxLen = 0;
        var maxLenWord = "";

        trieHead.terminal = true;

        for (var word : words) {
            boolean canBuildOffOthers = true;
            var curr = trieHead;
            for (var c : word.toCharArray()) {
                if (curr.next[c-'a'] == null)
                    curr.next[c-'a'] = new Node();
                canBuildOffOthers &= curr.terminal;
                curr = curr.next[c-'a'];
            }
            curr.terminal = true;
            if (canBuildOffOthers && maxLen < word.length()) {
                maxLen = word.length();
                maxLenWord = word;
            }
        }

        return maxLenWord;
    }
}
