class Solution {
private:
    int d(pair<int,int>& a, pair<int,int>& b) {
        const int df = a.first - b.first;
        const int ds = a.second - b.second;

        return df*df + ds*ds;
    }

public:
    int numberOfBoomerangs(vector<pair<int, int>>& points) {
        unordered_map<int,int> dist2count;
        int total = 0;

        for(int i = 0; i < points.size(); ++i) {
            for(int j = 0; j < points.size(); ++j)
                if(i != j) dist2count[d(points[i],points[j])]++;

            for(auto dist_count : dist2count)
                total += dist_count.second * (dist_count.second-1);

            dist2count.clear();
        }

        return total;
    }
};
