class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& findNums, vector<int>& nums) {
        unordered_map<int,int> nextGreater;
        stack<int> st;
        for(int n : nums) {
            while(!st.empty() && st.top() < n) {
                nextGreater[st.top()] = n;
                st.pop();
            }
            st.push(n);
        }

        vector<int> ret;
        for(int n : findNums)
            ret.push_back(nextGreater.count(n) ? nextGreater[n] : -1);

        return ret;
    }
};
