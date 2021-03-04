class Solution {
    public List<String> letterCasePermutation(String S) { // O(2^S * S)
        final var lc = letterCount(S);
        final var perms = genPerms(lc);
        final List<String> res = new ArrayList<>(perms.length);
        final var sb = new StringBuilder();
        for (var perm : perms) { // O(2^lc * S)
            int k = 0;
            for (int i = 0; i < S.length(); i++) { // O(S)
                final var c = S.charAt(i);
                if (notDigit(c)) {
                    if (perm.charAt(k) == '0') sb.append(Character.toLowerCase(c));
                    else sb.append(Character.toUpperCase(c));
                    k++;
                }
                else sb.append(c);
            }
            res.add(sb.toString()); // O(S)
            sb.setLength(0);
        }
        return res;
    }

    private static String[] genPerms(int k) { // O(2^k)
        final var permCount = (1 << (k+1)) - (1 << k);
        final var res = new String[permCount];
        int j = 0;
        for (int i = 1 << k; i < 1 << (k+1); i++) {
            res[j++] = Integer.toBinaryString(i).substring(1);
        }
        return res;
    }

    private static int letterCount(String s) { // O(n)
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (notDigit(s.charAt(i)))
                count++;
        }
        return count;
    }

    private static boolean notDigit(char c) { // O(1)
        return c < '0' || '9' < c;
    }
}
