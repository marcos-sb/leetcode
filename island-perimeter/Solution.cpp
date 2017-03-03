class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int perim = 0;
        for (int i = 0; i < grid.size(); i++) {
            vector<int> grid_i = grid[i];
            for(int j = 0; j < grid_i.size(); j++) {
                if(grid_i[j]) {
                    if(j == 0 || j > 0 && !grid_i[j-1])
                        perim++;
                    if(j == grid_i.size()-1 || j < grid_i.size()-1 && !grid_i[j+1])
                        perim++;
                    if(i == 0 || i > 0 && !grid[i-1][j])
                        perim++;
                    if(i == grid.size()-1 || i < grid.size()-1 && !grid[i+1][j])
                        perim++;
                }
            }
        }

        return perim;
    }
};
