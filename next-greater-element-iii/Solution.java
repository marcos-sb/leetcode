class Solution {
    public int nextGreaterElement(int n) {
        final var l = intToList(n);
        final var L = l.size();
        var i = L-2;
        while (0 <= i) {
            if (l.get(i) < l.get(i+1)) break;
            i--;
        }
        if (i < 0) return -1;
        
        var j = L-1;
        while (0 <= j && l.get(j) <= l.get(i)) j--;
        swap(l, i, j);

        Collections.reverse(l.subList(i+1,l.size()));

        return listToInt(l);
    }

    private static List<Integer> intToList(int n) {
        final var res = new ArrayList<Integer>();
        while (0 < n) {
            res.add(n%10);
            n /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    private static void swap(List<Integer> l, int i, int j) {
        final var tmp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, tmp);
    }

    private static int listToInt(List<Integer> l) {
        var res = 0l;
        for (var n : l) {
            res *= 10;
            res += n;
        }
        
        if (Integer.MAX_VALUE < res) return -1;

        return (int) res;
    }
}
