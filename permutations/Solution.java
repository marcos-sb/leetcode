class Solution {
  public List<List<Integer>> permute(int[] originalArray) {
    if (originalArray == null || originalArray.length < 1) return List.of();

    List<List<Integer>> perms = new ArrayList<>();
    perms.add(new ArrayList<>(){{ add(originalArray[0]); }});
    for (int i = 1; i < originalArray.length; i++) {
      final List<List<Integer>> allNewPerms = new ArrayList<>();
      for (List<Integer> p : perms) {
        for (int j = 0; j <= p.size(); j++) {
          final List<Integer> newPerms = new ArrayList<>();
          newPerms.addAll(p.subList(0, j));
          newPerms.add(originalArray[i]);
          newPerms.addAll(p.subList(j, p.size()));
          allNewPerms.add(newPerms);
        }
      }
      perms = allNewPerms;
    }

    return perms;
  }
}
