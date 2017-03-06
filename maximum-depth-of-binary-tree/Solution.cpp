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
    int _maxDepth(TreeNode* root, int currDepth) {
        if(!root) return currDepth;
        return max(_maxDepth(root->left,currDepth+1), _maxDepth(root->right,currDepth+1));
    }

public:
    int maxDepth(TreeNode* root) {
        if(!root) return 0;
        return max(_maxDepth(root->left,1), _maxDepth(root->right,1)); //tail_rec
    }
};
