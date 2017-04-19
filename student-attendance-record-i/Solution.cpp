class Solution {
public:
    bool checkRecord(string s) {
        regex not_rewardable(".*(A.*A|LLL).*");
        return !regex_match(s,not_rewardable);
    }
};