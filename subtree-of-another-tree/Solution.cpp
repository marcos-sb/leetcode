/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
private:
    vector<TreeNode*>& allRoots(TreeNode* node, int val, vector<TreeNode*>& roots) {
        if(!node) return roots;
        if(node->val == val)
            roots.push_back(node);
        allRoots(node->left,val,roots);

        return allRoots(node->right,val,roots);
    }

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

        vector<TreeNode*> roots;
        for(auto node : allRoots(s,t->val,roots))
            if(_isSubtree(node,t)) return true;

        return false;
    }
};