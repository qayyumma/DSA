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
