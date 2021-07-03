class Solution {
  public List<List<Integer>> permute(int[] originalArray) {
    return perms(originalArray, 0, new HashSet<>(), new ArrayList<>(), new ArrayList<>());
  }

  private static final List<List<Integer>> perms(int[] originalArray, int i,
    Set<Integer> seenInts, List<Integer> perm, List<List<Integer>> res
  ) {
    if (i == originalArray.length) {
      res.add(new ArrayList<>(perm));
      return res;
    }

    for (int el : originalArray) {
      if (seenInts.contains(el)) continue;
      perm.add(el);
      seenInts.add(el);

      perms(originalArray, i+1, seenInts, perm, res);

      perm.remove(perm.size()-1);
      seenInts.remove(el);
    }

    return res;
  }

}
