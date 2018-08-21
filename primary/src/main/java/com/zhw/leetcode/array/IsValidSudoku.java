package com.zhw.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhaihongwei
 * @date: 2018/8/13 20:30
 * @Description: 有效的数独
 * 题目：判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ['8','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Character[] strs = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[][] board2 = new char[9][9];
        char[][] board3 = new char[9][9];
        ArrayList<Character> list = new ArrayList<>(Arrays.asList(strs));
        if (!isRemove(board, (ArrayList<Character>) list.clone())) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board2[i][j] = board[j][i];

                // 计算九宫格的行列下标
                int r = j / 3 + i / 3 * 3;
                int c = (j % 3 + i * 3) % 9;
                board3[r][c] = board[i][j];
            }
        }

        if (!isRemove(board2, (ArrayList<Character>) list.clone())) {
            return false;
        }

        if (!isRemove(board3, (ArrayList<Character>) list.clone())) {
            return false;
        }


        return true;
    }

    private static boolean isRemove(char[][] board, ArrayList<Character> list) {
        for (int i = 0; i < board.length; i++) {
            ArrayList<String> removeList = (ArrayList<String>) list.clone();
            for (int j = 0; j < board[i].length; j++) {
                Character c = board[i][j];
                if (!c.equals('.') && !removeList.remove(c)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isValidSudoku2(char[][] board) {
        int[][] signs = new int[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int n = 1 << (board[i][j] - '1');
                int cubeIndex = i / 3 * 3 + j / 3;
                if ((signs[0][i] & n) != 0 || (signs[1][j] & n) != 0 || (signs[2][cubeIndex] & n) != 0)
                    return false;
                signs[0][i] |= n;
                signs[1][j] |= n;
                signs[2][cubeIndex] |= n;
            }
        }
        return true;
    }

    public boolean isValidSudoku3(char[][] board) {
        int len = board.length;
        boolean row[][] = new boolean[len][len];
        boolean col[][] = new boolean[len][len];
        boolean block[][] = new boolean[len][len];

        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                int c = board[i][j]-'1';
                if (c >= 0 && c <=8){
                    if (row[i][c] || col[c][j] || block[3*(i/3)+j/3][c])
                        return false;
                    row[i][c] = true;
                    col[c][j] = true;
                    block[3*(i/3)+j/3][c] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean validSudoku = isValidSudoku2(board);
        System.out.println(validSudoku);
    }
}
