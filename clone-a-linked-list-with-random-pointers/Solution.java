class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) return null;
    
    final Map<RandomListNode, RandomListNode> originalNode2copy = new HashMap<>();
    final RandomListNode dummyHead = new RandomListNode(-1);
    RandomListNode tail = dummyHead;
    RandomListNode curr = head;
    while (curr != null) {
      final int val = curr.val;
      final RandomListNode newNode = originalNode2copy.computeIfAbsent(curr, k -> new RandomListNode(val));
      tail.next = newNode;
      if (curr.random != null) {
        final int randomVal = curr.random.val;
        newNode.random = originalNode2copy.computeIfAbsent(curr.random, k -> new RandomListNode(randomVal));
      }
      tail = newNode;

      curr = curr.next;
    }

    return dummyHead.next;
  }
}
