package code;

import java.util.*;

public class leetcode1001 {
    public static void main(String[] args) {
        int N = 5;
        int[][] lamps = {{0, 0}, {1, 0}};
        int[][] queries = {{1, 1}, {1, 1}};
        int[] res = new leetcode1001().gridIllumination(N, lamps, queries);
        System.out.print(Arrays.toString(res));
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[][] array = new int[N][N];
        for (int[] t : lamps) {
            int i = t[0];
            int j = t[1];
            array[i][j] = 1;
        }
        int[] res = new int[queries.length];
        for (int index = 0; index < queries.length; index++) {
            int[] t = queries[index];
            int i = t[0];
            int j = t[1];
            res[index] = check(array, i, j, N);
            off(array, i, j, N);
        }
        return res;
    }

    private int check(int[][] array, int row, int col, int n) {

        // lie
        for (int i = 0; i < n; i++) {
            if (array[i][col] == 1) {
                return 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[row][i] == 1) {
                return 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != row && j != col && Math.abs(i - row) == Math.abs(j - col) && array[i][j] == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private void off(int[][] array, int row, int col, int n) {
        int startRow = Math.min(row - 1, 0);
        int endRow = Math.max(row + 1, n - 1);
        int startCol = Math.min(col - 1, 0);
        int endCol = Math.max(col + 1, n - 1);

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                array[i][j] = 0;
            }
        }
    }

    //10 0000 0000 L
    private static final long MAX_NUM = 1000000000L;

    private Map<Integer, Integer> rowMap = new HashMap<>();
    private Map<Integer, Integer> columnMap = new HashMap<>();
    private Map<Integer, Integer> sumMap = new HashMap<>();
    private Map<Integer, Integer> rowColDiffMap = new HashMap<>();

    // 标记某些位置是否有灯，10 0000 0000L * row + col
    private Set<Long> lampSet = new HashSet<>();

    private void setFlagMap(Map<Integer, Integer> flagMap, int key) {
        int count = flagMap.getOrDefault(key, 0);
        flagMap.put(key, count + 1);
    }

    private void minusFlagMapCount(Map<Integer, Integer> flagMap, int key) {
        flagMap.put(key, flagMap.get(key) - 1);
    }

    private void closeNeighborLamp(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow < 0 || newCol < 0) {
                    continue;
                }

                long lamp = MAX_NUM * newRow + newCol;
                if (lampSet.contains(lamp)) {
                    lampSet.remove(lamp);
                    minusFlagMapCount(rowMap, newRow);
                    minusFlagMapCount(columnMap, newCol);
                    minusFlagMapCount(sumMap, newRow + newCol);
                    minusFlagMapCount(rowColDiffMap, newRow - newCol);
                }
            }
        }
    }

    public int[] gridIllumination2(int N, int[][] lamps, int[][] queries) {
        int queryCount = queries.length;
        if (queryCount == 0) {
            return new int[]{};
        }

        for (int[] lamp : lamps) {
            int row = lamp[0];
            int col = lamp[1];
            int sum = row + col;
            int rowColDiff = row - col;
            setFlagMap(rowMap, row);
            setFlagMap(columnMap, col);
            setFlagMap(sumMap, sum);
            setFlagMap(rowColDiffMap, rowColDiff);
            lampSet.add(MAX_NUM * row + col);
        }

        int[] ansArr = new int[queryCount];
        int count = 0;

        for (int[] query : queries) {
            int row = query[0];
            int col = query[1];
            int sum = row + col;
            int rowColDiff = row - col;

            if (rowMap.containsKey(row) && rowMap.get(row) >= 1 ||
                    columnMap.containsKey(col) && columnMap.get(col) >= 1 ||
                    sumMap.containsKey(sum) && sumMap.get(sum) >= 1 ||
                    rowColDiffMap.containsKey(rowColDiff) && rowColDiffMap.get(rowColDiff) >= 1
            ) {
                ansArr[count++] = 1;
            } else {
                ansArr[count++] = 0;
            }

            // 关掉当前询问位置和周围相邻8个位置的灯
            closeNeighborLamp(row, col);
        }
        return ansArr;
    }
}
