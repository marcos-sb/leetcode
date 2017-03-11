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
    pair<ListNode*, ListNode*> _rev(ListNode* head) {
        if(!head->next)
            return {head,head};

        pair<ListNode*,ListNode*> tmp = _rev(head->next);
        tmp.first->next = head;
        tmp.first = head;
        head->next = nullptr;

        return tmp;
    }

public:
    ListNode* reverseList(ListNode* head) {
        if(!head) return nullptr;
        return _rev(head).second;
    }
};
