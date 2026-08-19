class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    continue;
                }

                char number = board[row][col];

                String rowKey = number + " int row " + row;

                String colKey = number + " in col " + col;

                String boxKey = number + " in box " + (row / 3) + "-" + (col / 3);
                if (!seen.add(rowKey)) {
                    return false;
                }

                if (!seen.add(colKey)) {
                    return false;
                }

                if (!seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}
