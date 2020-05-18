Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output: [0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
    
Example 2:
Input:
s: "abab" p: "ab"
Output: [0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

    
Solution :     
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        int letters[26] = {0};
        for(char c : p) letters[c - 'a']++;
        
        vector<int> result;
        int remaining = p.size(), j = 0;
        for(int i = 0; i< s.size(); i++){
            while(j < s.size() && j - i < p.size()){
                if(letters[s.at(j++) - 'a']-- > 0)
                    remaining--;
            }
            if(remaining == 0 && j - i == p.size()) 
                result.push_back(i);
            if(letters[s.at(i) - 'a']++ >= 0) 
                remaining++;            
        }
        return result;
    }
};
