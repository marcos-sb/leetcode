/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
private:
    ListNode* _removeElements(ListNode* node, int val, ListNode* head, ListNode* prev) {
        if(!node) return head;
        ListNode* _prev = prev;
        ListNode* _head = head;
        ListNode* _next = node->next;

        if(node->val == val) {
            if(_prev)
                _prev->next = _next;
            if(node == head)
                _head = _next;
            delete node;
        } else
            _prev = node;

        return _removeElements(_next,val,_head,_prev);
    }

public:
    ListNode* removeElements(ListNode* head, int val) {
        return _removeElements(head,val,head,nullptr);
    }
};
