class Solution {
public:
    string reverseVowels(string s) {
        unordered_set<char> vowels = {
            'a','e','i','o','u',
            'A','E','I','O','U'
        };
        int i = 0;
        int j = s.length()-1;
        char tmp;
        while(i < j)
            if(vowels.count(s[i]))
                while(i < j)
                    if(vowels.count(s[j])) {
                        tmp = s[i];
                        s[i] = s[j];
                        s[j] = tmp;
                        i++; j--;
                        break;
                    } else
                        j--;
            else
                i++;

        return s;
    }
};
