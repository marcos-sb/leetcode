class Solution {
    // This solution uses the start of `s` until `end` to store unique characters.
    // Whenever we see a duplicate pair between the current character `c` and
    // `arrS[end]`, we decrement `end` to mark that the new end of the string with
    // non-duplicate pairs.
    // When there's no duplicate (the `else` branch), we copy the character to the
    // non-duplicate part of the string.
    // New duplicates might be formed after "removing" a duplicate
    // between a character in the non-duplicate part of the string and another character.
    // A case like "abba" where we remove the first 'b' of the non-duplicate part and
    // then we remove the firt 'a'.
    // This case is taken care of with `end--`.
    public String removeDuplicates(String s) {
        final var S = s.length();
        final var arrS = s.toCharArray();
        var end = -1;
        for (var c : arrS) {
            if (0 <= end && arrS[end] == c) end--;
            else arrS[++end] = c;
        }

        return String.valueOf(arrS, 0, end+1);
    }
}
