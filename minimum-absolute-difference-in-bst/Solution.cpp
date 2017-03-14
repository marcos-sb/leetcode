/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// this solution implements the following idea but in O(1) space:
// the min abs diff between any two nodes in a BST lies between consecutive
// values in an in-order traversal of the tree.
// this algo calculates the those diffs. without building the in-order list first.
class Solution {
private:
    int _min = INT_MAX;
    pair<int,int> _PAIR = make_pair(-1,-1);

    pair<int,int> _minDiff(TreeNode* node, int parentVal) {
        if(!node) return _PAIR;

        // spread down parentVal when following pointers to the left children
        // to calculate the absolute difference between parentVal and
        // the value of the left-most sibling (next in-order value to parentVal)
        pair<int,int> _left = _minDiff(node->left, parentVal);
        if(_left.first > -1)
            _min = min(abs(node->val - _left.second), _min);
        if(parentVal > -1)
            _min = min(abs(node->val - parentVal), _min);

        // push my value when going down the right child
        // to calculate the absolute difference between
        // the next in-order value in the tree (left-most sibling of my right child)
        // and my value (line 29).
        pair<int,int> _right = _minDiff(node->right, node->val);
        if(_right.first > -1) {
            _min = min(abs(node->val - _right.first), _min);

        // if I have a right child return the pair my value and the right-most sibling's value
        // why? my value to calculate abs diff with my immediate parent's value, when going up
        // the recursive call stack; and the right-most of my sibling's value to calculate de abs diff
        // with the next in-order value if it exists.
            return make_pair(node->val, _right.second);
        } else
        // if I have no right links, return my value
            return make_pair(node->val, node->val);
    }

public:
    int getMinimumDifference(TreeNode* root) {
        if(!root) return -1;
        _minDiff(root, -1);

        return _min;
    }
};
