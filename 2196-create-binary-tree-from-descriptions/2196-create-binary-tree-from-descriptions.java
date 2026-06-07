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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();

        for(int[] des : descriptions){
            int parent=des[0];
            int child=des[1];
            int left=des[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child,new TreeNode(child));

            set.add(child);

            TreeNode parentNode=map.get(parent);
            TreeNode childNode=map.get(child);

            if(left==1){
                parentNode.left=childNode;
            }
            else{
                parentNode.right=childNode;
            }
        }

        for(int value : map.keySet()){
            if(!set.contains(value)){
                return map.get(value);
            }
        }
        return null;
    }
}