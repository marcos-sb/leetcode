package perform_string_shifts;

class Solution {
    public String stringShift(String s, int[][] shift) {
        final int[] totalShifts = new int[2];
        for (int[] sh : shift) {
            totalShifts[sh[0]] += sh[1];
        }
        final var balance = totalShifts[0] - totalShifts[1];
        final var modBalance = Math.abs(balance) % s.length();

        final var sb = new StringBuilder();
        if (0 < balance) {
            for (int i = modBalance; i < s.length(); i++)
                sb.append(s.charAt(i));
            for (int i = 0; i < modBalance; i++)
                sb.append(s.charAt(i));
        } else if (balance < 0) {
            for (int i = s.length()-modBalance; i < s.length(); i++)
                sb.append(s.charAt(i));
            for (int i = 0; i < s.length()-modBalance; i++)
                sb.append(s.charAt(i));
        }
        else
            return s;

        return sb.toString();
    }
}
