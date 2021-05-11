public class Solution {
    static class UnionFind {
        final int[] ids;
        UnionFind(int size) {
            this.ids = new int[size];
            for (int i = 0; i < ids.length; i++)
                ids[i] = i;
        }
        int find(char a) {
            return find(a-'a');
        }
        int find(int a) {
            while (a != ids[a]) {
                ids[a] = ids[ids[a]];
                a = ids[a];
            }
            return a;
        }
        int union(char a, char b) {
            return union(a-'a', b-'a');
        }
        int union(int a, int b) {
            int ida = find(a);
            int idb = find(b);
            ids[idb] = ida;
            return ida;
        }
    }

    public List<Integer> partitionLabels(String S) {
        final UnionFind parts = new UnionFind('z'-'a'+1);
        final boolean[] seen = new boolean['z'-'a'+1];
        for (int i = 0; i < S.length(); i++) {
            final char ci = S.charAt(i);
            final int cint = ci-'a';
            if (!seen[cint]) seen[cint] = true;
            else {
                final int cid = parts.find(ci);
                int j = i-1;
                char cj = S.charAt(j);
                while (j >= 0 && parts.find(cj) != cid) {
                    parts.union(ci, cj);
                    cj = S.charAt(--j);
                }
            }
        }

        final List<Integer> lengths = new ArrayList<>();
        int prevID = parts.find(S.charAt(0));
        int len = 1;
        for (int i = 1; i < S.length(); i++) {
            final char c = S.charAt(i);
            final int cid = parts.find(c);
            if (prevID == cid) {
                len++;
            } else {
                prevID = cid;
                lengths.add(len);
                len = 1;
            }
        }
        
        lengths.add(len);
        return lengths;
    }
}
