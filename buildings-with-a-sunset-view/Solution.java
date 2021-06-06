class Solution {
  public List<Integer> getBuildingsWithAView(int[] buildings) {
    int max = -1;
    final var res = new ArrayList<Integer>();
    for (int i = 0; i < buildings.length; i++) {
      if (buildings[i] > max) res.add(i);
      max = Math.max(max, buildings[i]);
    }
    return res;
  }
}
