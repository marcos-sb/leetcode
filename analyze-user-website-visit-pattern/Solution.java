class Solution {
    static class UTW {
        String uname, website;
        int ts;
        UTW(String uname, String website, int ts) {
            this.uname = uname;
            this.website = website;
            this.ts = ts;
        }
        @Override
        public String toString() {
            return String.format("%s,%s,%d", uname, website, ts);
        }
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        final var logs = new ArrayList<UTW>(username.length);
        for (int i = 0; i < username.length; i++)
            logs.add(new UTW(username[i], website[i], timestamp[i]));
        
        final Comparator<UTW> utwCmp = (a,b) -> Integer.compare(a.ts, b.ts);
        Collections.sort(logs, utwCmp);
        
        final Map<String, Integer> websiteIdx = new HashMap<>();
        final Map<Integer, String> idx2website = new HashMap<>();
        for (int i = 0, k = 0; i < website.length; i++)
            if (!websiteIdx.containsKey(website[i])) {
                websiteIdx.put(website[i], k);
                idx2website.put(k++, website[i]);
            }
        
        final Map<String, List<Integer>> userVisits = new HashMap<>();
        for (var utw : logs) {
            final var siteIdx = websiteIdx.get(utw.website);
            userVisits.computeIfAbsent(utw.uname, k -> new ArrayList<>())
                .add(siteIdx);
        }
        
        final Map<List<Integer>, Integer> patternScore = new HashMap<>();
        final var sz = 3;
        var maxScore = -1;
        List<List<Integer>> maxPatterns = new ArrayList<>();
        for (var entry : userVisits.entrySet()) {
            final var visits = genPatterns(entry.getValue(), 0, new ArrayList<>(3), new HashSet<>());
            for (var pattern : visits) {
                patternScore.put(pattern, patternScore.getOrDefault(pattern, 0)+1);
                final var patScore = patternScore.get(pattern);
                if (patScore == maxScore)
                    maxPatterns.add(pattern);
                else if (patScore > maxScore) {
                    maxScore = patScore;
                    maxPatterns = new ArrayList<>();
                    maxPatterns.add(pattern);
                }
            }
        }
        
        final List<List<String>> patterns = new ArrayList<>();
        for (var maxPattern : maxPatterns) {
            final var transformedPats = new ArrayList<String>(3);
            for (var siteIdx : maxPattern)
                transformedPats.add(idx2website.get(siteIdx));
            patterns.add(transformedPats);
        }
        
        final Comparator<List<String>> cmp = (a,b) -> {
            for (int i = 0; i < a.size(); i++) {
                final var comp = a.get(i).compareTo(b.get(i));
                if (comp != 0) return comp;
            }
            return 0;
        };
        Collections.sort(patterns, cmp);
        
        return patterns.get(0);
    }
    
    private static Set<List<Integer>> genPatterns(List<Integer> l, int i, List<Integer> partial, Set<List<Integer>> res) {
        if (partial.size() == 3) {
            res.add(new ArrayList<>(partial));
            return res;
        }
        if (i == l.size()) return res;
        
        for (int j = i; j < l.size(); j++) {
            partial.add(l.get(j));
            genPatterns(l, j+1, partial, res);
            partial.remove(partial.size()-1);
        }
        
        return res;
    }
}
