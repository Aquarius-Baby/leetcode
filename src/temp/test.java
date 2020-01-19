package temp;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
        int[][] res =   new test().clearZero(mat, 3);

        for(int[] t : res){
            System.out.println(Arrays.toString(t));
        }

    }

    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    continue;
                }
                if (mat[i][j] == 0 && visit[i][j] != true) {
                    deep(mat, visit, i, j, n);
                }
                visit[i][j] = true;
            }
        }
        return mat;
    }

    public void deep(int[][] mat, boolean[][] visit, int i, int j, int n) {
        for (int a = 0; a < n; a++) {
            mat[i][a] = 0;
            visit[i][a] = true;
        }
        for (int a = 0; a < n; a++) {
            mat[a][j] = 0;
            visit[a][j] = true;
        }
    }
}

class MyThread implements Runnable {
    int i = 0;

    public MyThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "=====" + i);
    }
}