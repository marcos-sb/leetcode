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
    TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
        if(!t1 && !t2)
            return nullptr;
        
        int t1val = t1 ? t1->val : 0;
        int t2val = t2 ? t2->val : 0;
        TreeNode* newNode = new TreeNode(t1val + t2val);
        
        TreeNode* t1left = NULL;
        TreeNode* t1right = NULL;
        TreeNode* t2left = NULL;
        TreeNode* t2right = NULL;
        if(t1) {
            t1left = t1->left;
            t1right = t1->right;
        }
        if(t2) {
            t2left = t2->left;
            t2right = t2->right;
        }
            
        newNode->left = mergeTrees(t1left, t2left);
        newNode->right = mergeTrees(t1right, t2right);
        
        return newNode;
    }
};