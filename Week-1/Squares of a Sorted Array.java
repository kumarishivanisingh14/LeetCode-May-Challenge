class Solution {
    public int[] sortedSquares(int[] A) {
        int square = 0;
        for(int i = 0; i < A.length; i++){
            int ele = A[i];
            square = ele * ele;
            A[i] = square;
        }
        Arrays.sort(A);
        return A;
    }
}