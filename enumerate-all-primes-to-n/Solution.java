class Solution {
  public List<Integer> enumeratePrimes(int n) {
    if (n < 2) return List.of();
    return sieve(n);
  }

  private static List<Integer> sieve(int n) {
    final var aux = new int[n+1];
    for (var i = 2; i < Math.sqrt(n); i++) {
      if (aux[i] == 1) continue;
      for (var j = 2*i; j <= n; j += i) aux[j] = 1;
    }
    
    final var res = new ArrayList<Integer>();
    for (var i = 2; i < n; i++)
      if (aux[i] == 0) res.add(i);
    return res;
  }
}
