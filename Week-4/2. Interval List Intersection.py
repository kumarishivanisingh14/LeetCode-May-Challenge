Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  
 The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  
 For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
    
Note:
1. 0 <= A.length < 1000
2. 0 <= B.length < 1000
3. 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9


NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.    

Solution:    
class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        i = 0
        j = 0
        
        result = []
        while i < len(A) and j < len(B):
            a_start, a_end = A[i]
            b_start, b_end = B[j]
            
            if a_start <= b_end and b_start <= a_end: 
                result.append([max(a_start, b_start), min(a_end, b_end)])
                
            if a_end <= b_end: 
                 i += 1               
            else:
                j += 1               
        return result
