class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return "";
        
        final Map<Character, Integer> bulls2count = new HashMap<>();
        final Map<Character, Integer> notBulls2count = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            final var sc = secret.charAt(i);
            final var gc = guess.charAt(i);
            if (sc == gc) {
                bulls2count.putIfAbsent(sc, 0);
                bulls2count.compute(sc, (k,v) -> v+1);
            } else {
                notBulls2count.putIfAbsent(sc, 0);
                notBulls2count.compute(sc, (k,v) -> v+1);
            }
        }
        int bulls = bulls2count.values().stream().reduce((a,b) -> a+b).orElse(0);
        
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            final var sc = secret.charAt(i);
            final var gc = guess.charAt(i);
            if (sc != gc && notBulls2count.containsKey(gc)) {
                notBulls2count.compute(gc, (k,v) -> {
                    final var newV = v-1;
                    if (newV == 0) return null;
                    return newV;
                });
                cows++;
            }
        }
        
        return String.format("%dA%dB", bulls, cows);
    }
}
