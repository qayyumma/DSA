Problem Description

In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
You have the following constraints:

Only one disk can be moved at a time.
A disk is slid off the top of one tower onto another tower.
A disk cannot be placed on top of a smaller disk.

You have to find the solution to the Tower of Hanoi problem.
You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
In each row, there should be 3 integers (disk, start, end), where:

disk - number of the disk being moved
start - number of the tower from which the disk is being moved
end - number of the tower to which the disk is being moved



Problem Constraints

1 <= A <= 18


Input Format

The first argument is the integer A.


Output Format

Return a 2D array with dimensions M x 3 as mentioned above in the description.


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
 //   public int[][] towerOfHanoi(int A) {

    public int[][] towerOfHanoi(int A) {
        List<int[]> result = new ArrayList<>();
        solveHanoi(A, 1, 3, 2, result);
        return result.toArray(new int[result.size()][3]);
    }

    private void solveHanoi(int n, int start, int end, int auxiliary, List<int[]> result) {
        if (n == 1) {
            result.add(new int[]{1, start, end});
            return;
        }

        solveHanoi(n - 1, start, auxiliary, end, result);
        result.add(new int[]{n, start, end});
        solveHanoi(n - 1, auxiliary, end, start, result);
    }



  //  }
}