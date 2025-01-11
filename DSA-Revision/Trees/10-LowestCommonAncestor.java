Problem Description

Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.


Problem Constraints

1 <= size of tree <= 100000

1 <= B, C <= 109


Input Format

First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.


Output Format

Return the LCA.


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {

    int ans = 0;

    public int lca(TreeNode A, int B, int C) {


        if( search(A, B)  == false || search(A, C) == false){
            return -1;
        }


        if(C==B){
            return B;
        }

        code(A, B, C);

        return ans;

    }

    public boolean code( TreeNode A, int B, int C ){


        if(A==null){
            return false;
        }

        if(A.val == B || A.val == C){

            ans = A.val;

            return true;

        }

        boolean left = code(A.left, B, C);

        boolean right = code(A.right, B, C);

        if(left == true && right ==true){

            ans = A.val;

        }

        return left || right;

    }

    public boolean search(TreeNode A, int V){

        if(A==null){
            return false;
        }

        if(A.val == V){
            return true;
        }

        boolean left = search(A.left, V);

        boolean right = search(A.right, V);

        return right || left;


    }


}

==================================================================================================================

Problem Description

Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.


Note 1 :- It is guaranteed that the nodes B and C exist.

Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.



Problem Constraints

1 <= Number of nodes in binary tree <= 105

1 <= B , C <= 105



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.


Output Format

Return the LCA of the two nodes


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int solve(TreeNode A, int B, int C) {

        if( check(A, B)== false || check(A, C)== false){
            return -1;
        }

        return code(A, B, C);

    }

    public int code(TreeNode A, int B, int C){

        if(A.val== C || A.val == B){
            return A.val;
        }

        else if(A.val < B && A.val < C){
            return code(A.right, B, C);
        }

        else if(A.val > B && A.val > C){
            return code(A.left, B, C);
        }

        return A.val;

    }


    public boolean check(TreeNode A, int v){

        if(A == null){
            return false;
        }

        if(A.val == v){
            return true;
        }

        boolean left = check(A.left, v );

        boolean right = check(A.right, v);

        return left || right;


    }
}

