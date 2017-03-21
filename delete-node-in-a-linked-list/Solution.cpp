/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        if(!node) return;
        ListNode* curr = node;
        ListNode* prev;
        while(curr->next) {
            curr->val = curr->next->val;
            prev = curr;
            curr = curr->next;
        }
        prev->next = nullptr;
        delete curr;
    }
};
