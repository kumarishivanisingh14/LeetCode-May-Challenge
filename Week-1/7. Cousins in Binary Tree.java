/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int depthX=-1,depthY=-1;
    TreeNode parentX,parentY,prev;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0);
      return depthX==depthY && parentX!=parentY;
    }
    public void dfs(TreeNode node, int x,int y, int depth){
       if(node==null)
           return;
        if(node.val==x){
            parentX=prev;
            depthX=depth;
            return;
        }
        else if(node.val==y){
            parentY=prev;
            depthY=depth;
            return;
        }
        prev=node;
        dfs(node.left,x,y,depth+1);
        dfs(node.right,x,y,depth+1);
        
    }
}