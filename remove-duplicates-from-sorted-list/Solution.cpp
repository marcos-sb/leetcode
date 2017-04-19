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
    ListNode* _ddup(ListNode* prev, ListNode* curr) {
        if (!curr) return prev;

        ListNode* newPrev = curr;
        if (prev->val == curr->val) {
            prev->next = curr->next;
            newPrev = prev;
            delete curr;
        }
        _ddup(newPrev,newPrev->next);

        return prev;
    }
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head) return nullptr;
        return _ddup(head,head->next);
    }
};