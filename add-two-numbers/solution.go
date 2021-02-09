func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var f func(l1, l2 *ListNode, carry int) *ListNode
    f = func(l1, l2 *ListNode, carry int) *ListNode {
        if l1 == nil && l2 == nil {
            if carry == 0 { return nil }
            return &ListNode{
                Val: carry % 10,
                Next: f(nil, nil, carry / 10),
            }
        }
        
        if l1 == nil { l1 = &ListNode{} }
        if l2 == nil { l2 = &ListNode{} }
        
        addedVal := l1.Val + l2.Val + carry
        ln := &ListNode{
            Val: addedVal % 10,
            Next: f(l1.Next, l2.Next, addedVal / 10),
        }
        return ln
    }
    
    return f(l1, l2, 0)
}

