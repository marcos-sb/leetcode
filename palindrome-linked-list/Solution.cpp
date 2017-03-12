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
    ListNode* _palindromeHelper(ListNode* node, int pos, int mid, bool odd) {
        ListNode* cmp;

        if(pos == mid && node->next) {
            if(odd)
                cmp = node->next->next;
            else
                cmp = node->next;
        } else
            cmp = _palindromeHelper(node->next,pos+1,mid,odd);

        if(cmp && node->val == cmp->val) {
            return pos == 0 ? node : cmp->next;
        } else return nullptr;
    }

public:
    bool isPalindrome(ListNode* head) {
        if(!head) return true;

        int len = 0;
        ListNode* node = head;
        while(node) {
            len++;
            node = node->next;
        }
        if(len == 1) return true;

        return _palindromeHelper(head,0,len/2 - 1, len % 2);
    }
};
