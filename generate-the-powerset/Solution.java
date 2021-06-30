class Solution {
  public List<List<Integer>> powerset(int[] inputSet) {
    if (inputSet == null || inputSet.length == 0) return List.of();

    final List<List<Integer>> powerset = new ArrayList<>();
    powerset.add(new ArrayList<>());
    
    for (int n : inputSet) {
      final List<List<Integer>> newSets = new ArrayList<>();
      for (List<Integer> set : powerset) {
        final List<Integer> newSet = new ArrayList(set);
        newSet.add(n);
        newSets.add(newSet);
      }
      powerset.addAll(newSets);
    }

    return powerset;
  }
}
