class Solution {
  public int pathSum(TreeNode root, int sum) {
    return pathSumRec(root, sum, new ArrayList<>());
  }

  private static int pathSumRec(TreeNode node, int sum, List<Integer> pathSums) {
    if (node == null) return 0;
    
    int pathCount = 0;
    final var newPathSums = new ArrayList<Integer>(pathSums.size()+1);
    for (var pathSum : pathSums) {
      final var newPathSum = pathSum - node.val;
      newPathSums.add(newPathSum);
      if (newPathSum == 0) pathCount++;
    }
    
    final var startingPathFromNode = sum - node.val;
    if (startingPathFromNode == 0) pathCount++;
    newPathSums.add(startingPathFromNode);

    pathCount += pathSumRec(node.left, sum, newPathSums);
    pathCount += pathSumRec(node.right, sum, newPathSums);

    return pathCount;
  }
}
