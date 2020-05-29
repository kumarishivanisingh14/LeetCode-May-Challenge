class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new List[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int[] d : dislikes) {
            int a = d[0] - 1, b = d[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] groupMap = new int[N]; 
        Arrays.fill(groupMap, -1);
        for (int i = 0; i < N; i++)
            if (groupMap[i] == -1 && !dfs(graph, i, 0, groupMap))
                return false;
        return true;
    }
    boolean dfs(List<Integer>[] graph, int src, int group, int[] groupMap) {
        if (groupMap[src] == 1 - group) return false; 
        if (groupMap[src] == group) return true; 
        groupMap[src] = group; 
        for (int v : graph[src])
            if (!dfs(graph, v, 1 - group, groupMap))
                return false;
        return true;
    }
}