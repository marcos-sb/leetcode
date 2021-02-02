func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    if l1 == nil {
        return l2
    }
    if l2 == nil {
        return l1
    }
    
    var head *ListNode
    if l1.Val < l2.Val {
        head = l1
        l1 = l1.Next
    } else {
        head = l2
        l2 = l2.Next
    }
    head.Next = head
    
    var _rec func (l1, l2, last *ListNode) *ListNode
    _rec = func (l1, l2, last *ListNode) *ListNode {
        if l1 == nil {
            last.Next = l2
            return head
        }
        if l2 == nil {
            last.Next = l1
            return head
        }
        if l1.Val < l2.Val {
            last.Next = l1
            l1 = l1.Next
        } else {
            last.Next = l2
            l2 = l2.Next
        }
        return _rec(l1, l2, last.Next)
    }
    
    return _rec(l1, l2, head)
}
