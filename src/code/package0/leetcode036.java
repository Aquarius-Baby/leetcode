package code.package0;


/**
 * 036 有效的数独
 *
 * 判断已填入的数字是否符合要求
 *
 */
public class leetcode036 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] cube = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '1';
                // row秘书行动
                if (row[i][num]) return false;
                else row[i][num] = true;

                // col秘书
                if (col[j][num]) return false;
                else col[j][num] = true;

                // cube秘书
                int ci = (i / 3) * 3 + (j / 3);
                if (cube[ci][num]) return false;
                else cube[ci][num] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '1';
                if (num >= 0 && num < 9) {
                    if(row[i][num]){
                        return false;
                    }
                    if(col[j][num]){
                        return false;
                    }
                    if(box[i/3][j/3][num]){
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i/3][j/3][num] = true;
                }
            }
        }
        return true;
    }
}
