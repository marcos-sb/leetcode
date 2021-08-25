/*
* Minimax: on each iteration pick the word that will produce the best outcome with the information that we have.
*
* Idea: any word `w` that matches the secret word on 'n' characters, will force any other word `w'` with a different
* number of matches between them to be removed from the set of candidate words `q` -- i.e. if `w` matches the secret
* word in 1 position, say idx 2, the secret will word follow the pattern **w[2]***, so any other word `w'` that doesn't match
* `w` in exactly 1 position cannot be the secret word. This is because, if, for example, `w'` has 2 matches with `w` we could reason that
* `w'` has the same character in the same position as the secret word, and a different character in any of the other 5
* positions -- because otherwise, `w` would have had that additional match with the secret word.
* 
* How to pick a word on each iteration? There're different options.
*
* What is the best possible choice (heuristic)? The word within the candidate words that has the most common characters among all of the
* candidates, as it's the word that could potentially remove the maximum number of candidates after we use it to guess.
*
*/
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        final var q = new ArrayDeque<String>();
        final var charFreq = new int[6]['z'-'a'+1]; // Frequency of each character on each of the 6 positions of the words
        for (var w : wordlist) {
            q.offer(w);
            for (var i = 0; i < 6; i++) charFreq[i][w.charAt(i)-'a']++;
        }
        
        while (!q.isEmpty()) {
            final var w = pickWord(q, charFreq);
            final var sim = master.guess(w);
            if (sim == 6) return; // found word
            filter(q, w, sim, charFreq);
        }
    }
    
    // Pick the word with the most common chars => potentially filters the most
    private static String pickWord(Queue<String> q, int[][] charFreq) {
        int maxScore = 0;
        String pick = q.peek();
        for (var w : q) {
            int wScore = 0;
            for (var i = 0; i < 6; i++) wScore += charFreq[i][w.charAt(i)-'a'];
            if (wScore > maxScore) {
                pick = w;
                maxScore = wScore;
            }
        }
        return pick;
    }
    
    private static int similarity(String s1, String s2) {
        var count = 0;
        for (var i = 0; i < s1.length(); i++)
            if (s1.charAt(i) == s2.charAt(i)) count++;
        return count;
    }

    // Filter all words from q that don't have the same similarity with the pick
    // as the pick has with the secret word.
    // The pick is always filtered, as the similarity of any word with itself is 6,
    // and `sim` here is < 6 (L:29).
    private static void filter(Queue<String> q, String w, int sim, int[][] charFreq) {
        var size = q.size();
        while (size-- > 0) {
            final var curW = q.poll();
            if (similarity(w, curW) == sim) q.offer(curW);
            else { // filter out curW, so update the charFreq to remove the chars in curW
                for (var i = 0; i < 6; i++) charFreq[i][curW.charAt(i)-'a']--;
            }
        }
    }
}
