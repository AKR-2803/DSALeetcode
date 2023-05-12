//Leetcode 116. Populating Next Right Pointers in Each Node 
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        solve(root);
        return root;
    }
    public void solve(Node root){
        if(root==null) return;
        
        if(root.left!=null) root.left.next=root.right;
        
        if(root.right!=null && root.next!=null) root.right.next=root.next.left;
        
        solve(root.left);
        solve(root.right);
    }
}
