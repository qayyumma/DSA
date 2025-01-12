Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.


Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 2


Input Format
The first argument given is the integer matrix A.

Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Inner class to represent a cell's coordinates in the grid
    class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // Method to check if a cell contains a fresh orange within the grid bounds
    public boolean canRot(int row, int col, int rows, int cols, int[][] grid) {
        return row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] == 1;
    }

    public int solve(int[][] grid) {
        Queue<Cell> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        int time = 0;

        // Initialize queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j)); // Add rotten oranges to queue
                } else if (grid[i][j] == 1) {
                    freshOranges++; // Count fresh oranges
                }
            }
        }

        // Directions for neighboring cells (left, right, up, down)
        int[][] directions = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };

        // BFS to rot adjacent oranges
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Cell rotten = queue.remove();

                for (int[] direction : directions) {
                    int newRow = rotten.row + direction[0];
                    int newCol = rotten.col + direction[1];

                    if (canRot(newRow, newCol, rows, cols, grid)) {
                        grid[newRow][newCol] = 2; // Make the fresh orange rotten
                        queue.add(new Cell(newRow, newCol));
                        freshOranges--;
                    }
                }
            }

            // Increment time after each level (one minute)
            if(!queue.isEmpty()){
                time++;
            }
        }

        // Return time if all oranges are rotten; otherwise, return -1
        return freshOranges == 0 ? time : -1;
    }
}
