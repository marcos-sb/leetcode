func deleteDuplicates(head *ListNode) *ListNode {
    var dd func(head *ListNode) (*ListNode, *int)
    dd = func(head *ListNode) (*ListNode, *int) {
        if head == nil { return nil, nil }
        
        next, deleted := dd(head.Next)
        
        if deleted != nil && *deleted == head.Val {
            return next, &head.Val
        }
        if next == nil {
            head.Next = next
            return head, nil
        }
        if head.Val != next.Val {
            head.Next = next
            return head, nil
        }
        // head.Val == next.Val
        return next.Next, &head.Val
    }
    
    ret, _ := dd(head)
    return ret
}
