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
    int path_sum(TreeNode * node, vector<int>& p_sums, int sum, int num_paths) {
        if(!node) return num_paths;
        int new_this_sums = 0;
        p_sums.push_back(node->val);

        int _path_sum = 0;
        for(auto it = p_sums.crbegin(); it != p_sums.crend(); ++it) {
            if(*it + _path_sum == sum) {
                ++new_this_sums;
            }
            _path_sum += *it;
        }

        int left_sums = path_sum(node->left, p_sums, sum, num_paths + new_this_sums);
        int total_sums = path_sum(node->right, p_sums, sum, left_sums);
        p_sums.pop_back();

        return total_sums;
    }

public:
    int pathSum(TreeNode* root, int sum) {
        vector<int> v;
        return path_sum(root, v, sum, 0);
    }
};