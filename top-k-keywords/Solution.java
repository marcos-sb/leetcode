public class Solution {
    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        final Set<Character> punct = initPunct();
        
        final Set<String> keyw = new HashSet<String>();
        for (String kw : keywords) keyw.add(kw);

        final Map<String, Integer> freqs = new HashMap<>();
        for (String review : reviews) {
            final Map<String, Integer> keywFreq = new HashMap<>();
            final String[] words = review.split("\\s+");
            for (String w : words) {
                final String cleanW = cleanup(w, punct);
                if (keyw.contains(cleanW)) keywFreq.put(cleanW, 1);
            }
            for (Map.Entry<String, Integer> entry : keywFreq.entrySet()) {
                final String key = entry.getKey();
                freqs.put(key, freqs.getOrDefault(key, 0) + 1);
            }
        }

        final List<String> res = new ArrayList<>();
        for (String kw : freqs.keySet()) {
            res.add(kw);
        }
        final Comparator<String> cmp = 
            (a,b) -> {
                final int freqCmp = Integer.compare(freqs.get(b),freqs.get(a));
                if (freqCmp == 0) return a.compareTo(b);
                return freqCmp;
            };
        Collections.sort(res, cmp);

        if (res.size() <= K) return res;
        return res.subList(0, K);
    }

    private static Set<Character> initPunct() {
        final Set<Character> punct = new HashSet<>();
        punct.add('[');
        punct.add('\\');
        punct.add('!');
        punct.add('?');
        punct.add(',');
        punct.add(';');
        punct.add('.');
        punct.add(']');
        return punct;
    }

    private static String cleanup(String s, Set<Character> punct) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (punct.contains(c)) continue;
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
