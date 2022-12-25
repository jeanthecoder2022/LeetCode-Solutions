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

//Time complexity of this solution is O(n)
// Space complexity O(n)
class Solution {
    Map<Integer,Integer> map ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        return helper(preorder, inorder, 0 , preorder.length -1, 0 , inorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        // Base case: if the start index is greater than the end index, we have an empty subtree
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
         // Create a new TreeNode for the root of this subtree
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inorderRootIndex = map.get(preorder[preStart]);
        int sizeOfLeftSubtree = inorderRootIndex - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + sizeOfLeftSubtree,inStart, inorderRootIndex - 1);
        root.right = helper(preorder, inorder, preStart + sizeOfLeftSubtree  + 1, preEnd, inorderRootIndex + 1,inEnd);
        
        return root;
        
    }
}
/*
preorder : Root Left Right
inorder : Left Root Right
*/
