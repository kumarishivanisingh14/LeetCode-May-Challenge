Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
    
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
    
Example 2:
Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
    
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:
1. 1 <= arr.length <= 300
2. 1 <= arr[0].length <= 300
3. 0 <= arr[i][j] <= 1


Solution:
class Solution {
    public int countSquares(int[][] matrix) {
        int mat[][] = new int[matrix.length + 1][matrix[0].length + 1];
        int sum = 0;
        
         for(int i = 1; i <= matrix.length; i++)
            for(int j = 1; j <= matrix[0].length; j++)
                if(matrix[i - 1][j - 1] != 0)
                    sum += (mat[i][j] = Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]) + 1);
        return sum;
        
    }
}
