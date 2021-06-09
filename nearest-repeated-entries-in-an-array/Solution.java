class Solution {
  public int distanceOfClosestRepeatedEntries(String[] sentence) {
    if (sentence == null) return -1;

    var min = Integer.MAX_VALUE;
    final var word2idx = new HashMap<String, Integer>();
    for (int i = 0; i < sentence.length; i++) {
      if (word2idx.containsKey(sentence[i])) {
        min = Math.min(min, i - word2idx.get(sentence[i]));
      }
      word2idx.put(sentence[i], i);
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
