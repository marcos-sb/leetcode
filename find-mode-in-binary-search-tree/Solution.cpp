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
    void fm(TreeNode* root, unordered_map<int,int>& freqs) {
        if(!root) return;
        freqs[root->val]++;
        fm(root->left, freqs);
        fm(root->right, freqs);
    }

public:
    vector<int> findMode(TreeNode* root) {
        unordered_map<int,int> freqs;
        vector<int> ret;

        fm(root,freqs);

        int max_freq = 0;
        for(auto kv : freqs)
            max_freq = max(kv.second,max_freq);

        for(auto kv : freqs)
            if(kv.second == max_freq)
                ret.push_back(kv.first);

        return ret;
    }
};