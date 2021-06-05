class Solution {
  public List<List<Integer>> threeSum(int[] A) {
    final var map = new HashMap<Integer, Integer>();
    final Set<Set<Integer>> res = new HashSet<>();
    for (var i = 0; i < A.length-1; i++) {
      for (var j = i+1; j < A.length; j++) {
        final var sum = A[i] + A[j];
        if (map.containsKey(-sum))
          res.add(Set.of(A[i],A[map.remove(-sum)],A[j]));
        else
          map.put(A[j], j);
      }
      map.clear();
    }

    final List<List<Integer>> ret = new ArrayList<>();
    for (var s : res) ret.add(new ArrayList(s));
    return ret;
  }
}
