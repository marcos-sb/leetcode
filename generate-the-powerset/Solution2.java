class Solution2 {
  public List<List<Integer>> powerset(int[] inputSet) {
    if (inputSet == null || inputSet.length == 0) return List.of();
    
    final List<List<Integer>> res = new ArrayList<>();
    rec(inputSet, 0, new ArrayList<>(), res);
    
    return res;
  }

  private static void rec(int[] set, int i, List<Integer> partialSet, List<List<Integer>> powerset) {
    if (i == set.length) {
      powerset.add(new ArrayList<>(partialSet));
      return;
    }
    partialSet.add(set[i]);
    rec(set, i+1, partialSet, powerset);

    partialSet.remove(partialSet.size()-1);
    rec(set, i+1, partialSet, powerset);
  }
}
