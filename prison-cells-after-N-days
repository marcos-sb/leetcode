class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        final Map<Integer,Integer> num2pos = new HashMap<>(1 << 8);
        final List<Integer> prisonState = new ArrayList<>(1 << 8);
        for (int i = 0; i <= N; i++) {
            final int state = arrayToInt(cells);
            if (num2pos.containsKey(state)) {
                final int pos = num2pos.get(state);
                return intToArray(prisonState.get(pos + ((N-i) % (prisonState.size()-pos))));
            } else {
                num2pos.put(state,i);
                prisonState.add(state);
            }
            cells = newState(cells);
        }
        return intToArray(prisonState.get(N));
    }
    private static int[] newState(int[] cells) {
        final int[] newCells = new int[cells.length];
        for (int i = 1; i < cells.length-1; i++)
            newCells[i] = 1 - (cells[i-1] ^ cells[i+1]);
        return newCells;
    }
    private static int[] intToArray(int n) {
        final int[] res = new int[8];
        int i = 0;
        while (n > 0) {
            res[res.length-i-1] = n % 10;
            n /= 10;
            i++;
        }
        return res;
    }
    private static int arrayToInt(int[] cells) {
        int n = 0;
        for (int i = 0; i < cells.length; i++) {
            n *= 10;
            n += cells[i];
        }
        return n;
    }
}
