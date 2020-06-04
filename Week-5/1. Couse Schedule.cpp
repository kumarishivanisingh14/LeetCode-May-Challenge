class Solution {
    bool ans = true;
public:
    void dfs(int k, vector<vector<int>>& g, vector<int>& v, int p){
        if(!ans) return;
        v[k]=2;
        for(int i=0;i<g[k].size();i++){
            if(v[g[k][i]] == 0){
                dfs(g[k][i],g,v,p);
            }
            else if(v[g[k][i]] == 2){
                ans = false;
                return;
            }
        }
        v[k]=1;
    }
    bool canFinish(int n, vector<vector<int>>& p) {
        vector<vector<int>> g(n, vector<int>());
        for(int i=0;i<p.size();i++)
            g[p[i][1]].push_back(p[i][0]);
        vector<int> v(n,0);
        for(int i=0;i<g.size();i++){
            if(v[i]==0){
                dfs(i,g,v,n);
            }
        }
        return ans;
    }
};