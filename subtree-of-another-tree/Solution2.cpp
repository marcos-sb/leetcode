/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution2 {
private:
    bool _isSubtree(TreeNode* s, TreeNode* t) {
        if(!s && !t) return true;
        if(!s || !t) return false;

        return (s->val == t->val) &&
            _isSubtree(s->left,t->left) &&
            _isSubtree(s->right,t->right);
    }
public:
    bool isSubtree(TreeNode* s, TreeNode* t) {
        if(!s && !t) return true;
        if(!s || !t) return false;

        return
            _isSubtree(s,t) ||
            (isSubtree(s->left,t) || isSubtree(s->right,t));
    }
};