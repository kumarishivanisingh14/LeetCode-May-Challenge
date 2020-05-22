class Solution:
    def frequencySort(self, s: str) -> str:
        dict = {}
        result = ''
        
        for i in s:
            if i in dict:
                dict[i] += 1
            else:
                dict[i] = 1
        s = sorted(dict, key=lambda x : dict[x], reverse = True)
        
        for char in s:
            result += char * dict[char]
            
        return result
        