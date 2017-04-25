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
    const pair<int,int>* zero = new pair<int,int> {0,0};

    const pair<int,int>* _ft(TreeNode* node) {
        if(!node) return zero; // {tilt,value}
        const pair<int,int>* left = _ft(node->left);
        const pair<int,int>* right = _ft(node->right);
        const int node_tilt = abs(left->second - right->second);
        const int total_tilt = node_tilt + left->first + right->first;
        const int total_val = node->val + left->second + right->second;

        return new pair<int,int> {total_tilt, total_val};
    }
public:
    int findTilt(TreeNode* root) {
        return _ft(root)->first;
    }
};