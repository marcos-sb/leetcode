class Solution {
public:
    vector<int> constructRectangle(int area) {
        int w = floor(sqrt(area));

        while(w > 0 && area % w != 0) w--;

        const int l = area / w;

        return {l,w};
    }
};
