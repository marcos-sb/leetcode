class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        if(k < 0) return 0;

        unordered_map<int,unordered_map<int,int>> pairCandidates;
        int i = 0;
        for(int n : nums) {
            const int n_k = n-k;
            const int nk = n + k;
            if(!pairCandidates.count(n_k))
                pairCandidates[n_k] = {};
            pairCandidates[n_k][n] = i;

            if(!pairCandidates.count(nk))
                pairCandidates[nk] = {};
            pairCandidates[nk][n] = i;

            ++i;
        }

        unordered_set<int> sumPairs;
        int uniquePairCount = 0;
        i = 0;
        for(int n : nums) {
            if(pairCandidates.count(n))
                for(auto kv : pairCandidates[n]) {
                    int m = kv.first;
                    int pos = kv.second;
                    if(pos != i && !sumPairs.count(n+m)) {
                        sumPairs.insert(n+m);
                        uniquePairCount++;
                    }
                }
            ++i;
        }
        return uniquePairCount;
    }
};
