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
    TreeNode* _sortedArrayToBST(vector<int>& nums, int lo, int hi) {
        if(hi < lo)
            return nullptr;

        const int len = hi - lo + 1;
        const int mid = len / 2 + lo;
        TreeNode* node = new TreeNode(nums[mid]);
        if(lo < hi) {
            node->left = _sortedArrayToBST(nums, lo, mid-1);
            node->right = _sortedArrayToBST(nums, mid+1, hi);
        }

        return node;
    }

public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return _sortedArrayToBST(nums, 0, nums.size()-1);
    }
};
