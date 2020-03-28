// Brute-Force solution: use three nested for-loop
// Time complexity: O(1)
// Space complexity: O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        
        // check by rows
        for (int col = 0; col < 9; col++) {
            Arrays.fill(visited, false);
            for (int row = 0; row < 9; row++) {
                if (!checkValid(visited, board[row][col])) {
                    return false;
                }
            }
        }
        
        // check by columns
        for (int row = 0; row < 9; row++) {
            Arrays.fill(visited, false);
            for (int col = 0; col < 9; col++) {
                if (!checkValid(visited, board[row][col])) {
                    return false;
                }
            }
        }
        
        // check by sub boxes
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!checkValid(visited, board[row + k / 3][col + k % 3])) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean checkValid(boolean[] visited, char cell) {
        if (cell == '.') {
            return true;
        }
        else if (cell < '1' && cell >'9') {
            return false;
        }
        else if (visited[cell - '1']) {
            return false;
        }
        else {
            visited[cell - '1'] = true;
            return true;
        }
    }
}
// Optimized solution: use one-pass nested for-loop
// Time complexity: O(1)
// Space complexity: O(1)
