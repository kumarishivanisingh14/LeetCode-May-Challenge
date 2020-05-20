# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans = 0
        self.was_found = False
        self.cur_k = 0
        
    def _kthSmallest(self, root):
        if self.was_found or not root:
            return
        
        self._kthSmallest(root.left)
        self.cur_k+=1
        if self.cur_k == self.desired_k:
            self.ans = root.val
            self.was_found == True
        self._kthSmallest(root.right)
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.desired_k = k
        self._kthSmallest(root)
        return self.ans