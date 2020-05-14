In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
    
Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
    
Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:
1. The number of nodes in the tree will be between 2 and 100.
2. Each node has a unique integer value from 1 to 100.

Solution:
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
