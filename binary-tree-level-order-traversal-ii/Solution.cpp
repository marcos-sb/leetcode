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
    vector<vector<int>>& _lbo(TreeNode* node, int curr_lvl, vector<vector<int>>& lvls) {
        if(!node) return lvls;
        lvls[lvls.size()-1-curr_lvl].push_back(node->val);
        _lbo(node->left,curr_lvl+1,lvls);

        return _lbo(node->right,curr_lvl+1,lvls);
    }

public:
    int treeHeight(TreeNode* root, int height) {
        if(!root) return height;
        return max(treeHeight(root->left, height+1), treeHeight(root->right, height+1));
    }

    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        const int height = treeHeight(root,0);
        vector<vector<int>> v(height, vector<int>());
        vector<vector<int>>& res = _lbo(root,0,v);

        return res;
    }
};