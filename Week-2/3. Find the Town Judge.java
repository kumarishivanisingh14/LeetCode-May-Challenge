class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trust_count = new int[N+1];
        for(int[] temp: trust){
            trust_count[temp[0]]--;
            trust_count[temp[1]]++;
        }
        for(int i = 1; i <= N; ++i){
            if(trust_count[i] == N-1)
                return i;
        }
        return -1;
        
    }
}