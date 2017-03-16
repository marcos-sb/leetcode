class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int count = 0;
        int si = 0;
        for(int gi = 0; gi < g.size(); ++gi) {
            while(si < s.size() && g[gi] > s[si]) { si++; }
            if(si++ < s.size())
                count++;
            else
                break;
        }

        return count;
    }
};
