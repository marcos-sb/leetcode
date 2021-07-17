class Solution {
  public String makeStringValid(String s) {
    final Set<Integer> invalidPos = new HashSet<>();
    final Deque<Integer> helperStack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      switch (c) {
        case '(':
          helperStack.offerLast(i);
          break;
        case ')':
          if (helperStack.isEmpty()) invalidPos.add(i);
          else helperStack.pollLast();
          break;
      }
    }
    while (!helperStack.isEmpty())
      invalidPos.add(helperStack.pollLast());
    
    final StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (invalidPos.contains(i)) continue;
      res.append(s.charAt(i));
    }

    return res.toString();
  }
}
