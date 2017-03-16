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
    int _sumll(TreeNode* node, bool left) {
        if(!node) return 0;

        if(left && !node->left && !node->right)
            return node->val;
        
        return _sumll(node->left,true) + _sumll(node->right,false);
    }

public:
    int sumOfLeftLeaves(TreeNode* root) {
        if(!root) return 0;
        return _sumll(root,false);
    }
};
