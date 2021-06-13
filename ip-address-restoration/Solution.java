class Solution {
    public List<String> restoreIpAddresses(String rawIpString) {
        if (rawIpString == null || rawIpString.isEmpty())
            return List.of();

        final var res = new ArrayList<String>();
        final var sb = new StringBuilder();

        for (var dotDelta = 1; dotDelta < 4 && dotDelta < rawIpString.length(); dotDelta++) {
            for (var j = 0; j < dotDelta; j++)
                sb.append(rawIpString.charAt(j));

            if (!valid(rawIpString, 0, dotDelta)) {
                sb.setLength(sb.length()-dotDelta);
                continue;
            }

            restoreRec(rawIpString, dotDelta, 0, res, sb);

            sb.setLength(sb.length()-dotDelta);
        }

        return res;
    }

    private static void restoreRec(String rawIpString, int i, int dots, List<String> res, StringBuilder sb) {
        if (i >= rawIpString.length() || dots >= 3) {
            if (dots == 3 && i == rawIpString.length())
                res.add(sb.toString());
            return;
        }

        sb.append('.');
        for (var dotDelta = 1; dotDelta < 4 && i+dotDelta <= rawIpString.length(); dotDelta++) {
            for (var j = 0; j < dotDelta; j++)
                sb.append(rawIpString.charAt(i+j));

            if (!valid(rawIpString, i, i+dotDelta)) {
                sb.setLength(sb.length()-dotDelta-1);
                return;
            }

            restoreRec(rawIpString, i+dotDelta, dots+1, res, sb);

            sb.setLength(sb.length()-dotDelta);
        }
        sb.setLength(sb.length()-1);
    }

    private static boolean valid(String s, int from, int to) {
        var num = 0;
        for (var i = from; i < to; i++) {
            num *= 10;
            num += s.charAt(i) - '0';
        }
        return num <= 255;
    }
}
