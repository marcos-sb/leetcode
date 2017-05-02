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
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root || !p || !q) return nullptr;

        auto left = lowestCommonAncestor(root->left,p,q);
        auto right = lowestCommonAncestor(root->right,p,q);

        if(root == p || root == q)
            return root;

        if(left == p && (root == q || right == q) )
            return root;

        if(left == q && (root == p || right == p) )
            return root;

        if(right == p && (root == q || left == q) )
            return root;

        if(right == q && (root == p || left == p) )
            return root;

        return left ? left : right;
    }
};