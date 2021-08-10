class Solution {
    static class Node {
        boolean terminal;
        Node[] next;
        SortedSet<String> words;
        Node() {
            terminal = false;
            next = new Node['z'-'a'+1];
            final Comparator<String> cmp = (a,b) -> b.compareTo(a);
            words = new TreeSet<>(cmp);
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        final var root = makeTrie(products);
        final List<List<String>> res = new ArrayList<>();
        
        var curr = root;
        for (int i = 0; i < searchWord.length(); i++) {
            final var c = searchWord.charAt(i);
            final var idx = c - 'a';
            curr = curr.next[idx];
            if (curr == null) break;
            res.add(reverse(new ArrayList<>(curr.words)));
        }
        
        final var sizeSoFar = res.size();
        for (int i = 0; i < searchWord.length()-sizeSoFar; i++) {
            res.add(List.of());
        }
        
        return res;
    }
    
    private static Node makeTrie(String[] products) {
        final var root = new Node();
        for (var p : products) {
            var curr = root;
            for (int i = 0; i < p.length(); i++) {
                final var c = p.charAt(i);
                final var idx = c - 'a';
                if (curr.next[idx] == null)
                    curr.next[idx] = new Node();
                curr = curr.next[idx];
                
                if (curr.words.size() < 3)
                    curr.words.add(p);
                else if (p.compareTo(curr.words.first()) < 0) {
                    curr.words.remove(curr.words.first());
                    curr.words.add(p);
                }
            }
            curr.terminal = true;
        }
        return root;
    }
    
    private static <T> List<T> reverse(List<T> l) {
        if (l.isEmpty()) return l;
        for (int i = 0; i < l.size()/2; i++)
            swap(l, i, l.size()-i-1);
        return l;
    }
    
    private static <T> void swap(List<T> l, int i, int j) {
        final var tmp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, tmp);
    }
}
