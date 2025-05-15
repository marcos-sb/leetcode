class Solution {
    public String reorganizeString(String s) {
        final var freqs = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }
        var maxFreq = 0;
        var letter = '\0';
        for (var entry : freqs.entrySet()) {
            final var frequency = entry.getValue();
            if (maxFreq < frequency) {
                maxFreq = frequency;
                letter = entry.getKey();
            }
        }

        final var S = s.length();
        if ((S + 1) / 2 < maxFreq) {
            return "";
        }

        final var res = new char[S];
        var i = 0;
        while (0 < maxFreq--) {
            res[i] = letter;
            i += 2;
        }
        freqs.remove(letter);

        for (var entry : freqs.entrySet()) {
            letter = entry.getKey();
            var freq = entry.getValue();
            while (0 < freq--) {
                if (res.length <= i) {
                    i = 1;
                }
                res[i] = letter;
                i += 2;
            }
        }

        return new String(res);
    }
}
