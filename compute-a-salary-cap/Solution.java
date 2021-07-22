class Solution {
  public int computeSalaryCap(int[] salaries, int budget) {
    Arrays.sort(salaries);
    
    int sum = 0;
    for (int sal : salaries) sum += sal;

    int index = salaries.length-1;
    while (index > 0) {
      sum -= salaries[index];
      
      final int kElements = salaries.length - index;
      final int k = (budget - sum) / kElements;

      if (k >= salaries[index-1]) return k;

      index--;
    }

    return budget / salaries.length;
  }
}
