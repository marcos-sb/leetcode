class Solution {
  public List<List<Integer>> threeSum(int[] A) {
    countingSort(A);

    final List<List<Integer>> res = new ArrayList<>();
    final Map<Integer, Set<Integer>> used = new HashMap<>();
    for (int i = 0; i < A.length-2; i++) {
      final var usedAi = used.computeIfAbsent(A[i], k -> new HashSet<>());
      var j = i+1;
      var k = A.length-1;
      while (j < k) {
        if (usedAi.contains(A[j])) {
          j++;
          continue;
        }
        final var sum = A[i] + A[j] + A[k];
        if (sum == 0) {
          res.add(List.of(A[i], A[j], A[k]));
          usedAi.add(A[j]);
          j++;
        } else if (sum < 0) j++;
        else k--;
      }
    }

    return res;
  }

  private static void countingSort(int[] arr) {
    if (arr.length <= 1) return;
    
    var min = Integer.MAX_VALUE;
    var max = Integer.MIN_VALUE;
    for (var n : arr) {
      min = Math.min(n, min);
      max = Math.max(n, max);
    }

    final var freqs = new int[max-min+1];
    for (var n : arr) freqs[n-min]++;
    var i = 0;
    for (int j = 0; j < freqs.length; j++) {
      while (freqs[j]-- > 0) arr[i++] = j+min;
    }
  }
}
