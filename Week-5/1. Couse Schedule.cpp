There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
    
Constraints:
1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
2. You may assume that there are no duplicate edges in the input prerequisites.
3. 1 <= numCourses <= 10^5

Solution : 
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
