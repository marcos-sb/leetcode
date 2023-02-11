/**
 *
 * This solution uses a sliding window with two pointers,
 * frequencies of characters in the window, and remaining
 * letters to know when an anagram of `p` is present in
 * the window.
 *
 * In order to understand the approach you have to keep the
 * following ideas in mind:
 * - `freqs` contains the count of each character of `p` that
 *   is not yet in the window. Positive integers represent
 *   a defect of characters (characters that we'll need to add),
 *   negative integers represent an excess, and 0 means exact
 *   number of characters of `p` in the window.
 * - `remaningLetters` is the number of different letters that
 *   are missing in the window to complete an anagram. This
 *   variable only contains positive integers.
 * - When we add a new character to the window, we decrement
 *   the number of characters required to meet an anagram. If
 *   that number becomes 0, it means we don't need additional copies
 *   of that character to make an anagram, so we substract 1
 *   from `remaningLetters` to account for that fact.
 * - We only really need to remove a character from the window when
 *   the length of the window is 1 over the length of `p`. And when
 *   we do, we increment the frequency required in the window
 *   for that character by 1. And if the new frequency is 1,
 *   it means we have just removed a character from the window
 *   that was present in `p`, and so we increment `remainingLetters`
 *   by 1.
 * - Any substring of `s` would have to have the same length of `p`
 *   in order to be a potential anagram. So it's only when we add a
 *   new character to the window that we have to check if the
 *   window contains an anagram of `p`.
 *
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final var pLen = p.length();
        final var freqs = new int['z'-'a'+1];
        var remainingLetters = 0;
        for (var i = 0; i < pLen; i++) {
            final var c = p.charAt(i);
            final var freq = ++freqs[c-'a'];
            if (freq == 1) remainingLetters++;
        }
        
        final var res = new ArrayList<Integer>();
        var i = 0;
        for (var j = 0; j < s.length(); j++) {
            if (j-i == pLen) {
                final var l = s.charAt(i);
                final var fl = ++freqs[l-'a'];
                if (fl == 1) remainingLetters++;
                i++;
            }
            final var r = s.charAt(j);
            final var fr = --freqs[r-'a'];
            if (fr == 0) remainingLetters--;
            if (remainingLetters == 0) res.add(i);
        }

        return res;
    }
}
