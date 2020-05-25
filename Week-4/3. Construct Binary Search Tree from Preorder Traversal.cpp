/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* insertBST(TreeNode* root,int key){
        if(root==NULL){
            return new TreeNode(key);
        }
        
        if(key<root->val){
            root->left = insertBST(root->left,key);
        }
        else if(key>root->val){
            root->right = insertBST(root->right,key);
        }
        
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder){
        TreeNode* root = new TreeNode();
        root=NULL;
        
        for(auto i=preorder.begin();i!=preorder.end();i++){
            root=insertBST(root,*i);
        }
        
        return root;
    }
};