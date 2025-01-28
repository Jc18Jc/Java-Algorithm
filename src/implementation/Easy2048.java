package implementation;

import java.io.*;
import java.util.Arrays;

class Stack {
    int i;
    int j;
    int value;
    boolean check;

    public Stack(int i, int j, int value, boolean check) {
        this.i = i;
        this.j = j;
        this.value = value;
        this.check = check;
    }

    public Stack(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
        this.check = false;
    }


    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getValue() {
        return value;
    }

    public boolean isCheck() {
        return check;
    }

}

public class Easy2048 {
    static int N;
    static Stack[] stc;

    static int down(int count, int[][] cMap) {
        int[][] fMap = new int[N][N];
        for (int l = 0; l < N; l++) {
            fMap[l] = Arrays.copyOf(cMap[l], N);
        }
        for (int k = 0; k < N; k++) {
            stc[k] = new Stack(N - 1, k, fMap[N - 1][k]);
        }

        for (int i = N - 2; i > -1; i--) {
            for (int j = 0; j < N; j++) {
                if (fMap[i][j] == 0) continue;
                Stack s = stc[j];
                if (s.getValue() == 0) {
                    stc[j] = new Stack(s.getI(), j, fMap[i][j]);
                    fMap[s.getI()][j] = fMap[i][j];
                    fMap[i][j] = 0;
                } else if (s.getValue() == fMap[i][j] && !s.isCheck()) {
                    stc[j] = new Stack(s.getI(), j, fMap[i][j] * 2, true);
                    fMap[s.getI()][j] = fMap[i][j] * 2;
                    fMap[i][j] = 0;
                } else {
                    stc[j] = new Stack(s.getI() - 1, j, fMap[i][j]);
                    fMap[i][j] = 0;
                    fMap[stc[j].getI()][j] = stc[j].getValue();
                }
            }
        }

        return dfs(count + 1, fMap);
    }

    static int up(int count, int[][] cMap) {
        int[][] fMap = new int[N][N];
        for (int l = 0; l < N; l++) {
            fMap[l] = Arrays.copyOf(cMap[l], N);
        }

        for (int k = 0; k < N; k++) {
            stc[k] = new Stack(0, k, fMap[0][k]);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (fMap[i][j] == 0) continue;
                Stack s = stc[j];
                if (s.getValue() == 0) {
                    stc[j] = new Stack(s.getI(), j, fMap[i][j]);
                    fMap[s.getI()][j] = fMap[i][j];
                    fMap[i][j] = 0;
                } else if (s.getValue() == fMap[i][j] && !s.isCheck()) {
                    stc[j] = new Stack(s.getI(), j, fMap[i][j] * 2, true);
                    fMap[s.getI()][j] = fMap[i][j] * 2;
                    fMap[i][j] = 0;
                } else {
                    stc[j] = new Stack(s.getI() + 1, j, fMap[i][j]);
                    fMap[i][j] = 0;
                    fMap[stc[j].getI()][j] = stc[j].getValue();
                }
            }
        }

        return dfs(count + 1, fMap);
    }

    static int right(int count, int[][] cMap) {
        int[][] fMap = new int[N][N];
        for (int l = 0; l < N; l++) {
            fMap[l] = Arrays.copyOf(cMap[l], N);
        }

        for (int k = 0; k < N; k++) {
            stc[k] = new Stack(k, N - 1, fMap[k][N - 1]);
        }

        for (int j = N - 2; j > -1; j--) {
            for (int i = 0; i < N; i++) {
                if (fMap[i][j] == 0) continue;
                Stack s = stc[i];
                if (s.getValue() == 0) {
                    stc[i] = new Stack(i, s.getJ(), fMap[i][j]);
                    fMap[i][s.getJ()] = fMap[i][j];
                    fMap[i][j] = 0;
                } else if (s.getValue() == fMap[i][j] && !s.isCheck()) {
                    stc[i] = new Stack(i, s.getJ(), fMap[i][j] * 2, true);
                    fMap[i][s.getJ()] = fMap[i][j] * 2;
                    fMap[i][j] = 0;
                } else {
                    stc[i] = new Stack(i, s.getJ() - 1, fMap[i][j]);
                    fMap[i][j] = 0;
                    fMap[i][stc[i].getJ()] = stc[i].getValue();
                }
            }
        }

        return dfs(count + 1, fMap);
    }

    static int left(int count, int[][] cMap) {
        int[][] fMap = new int[N][N];
        for (int l = 0; l < N; l++) {
            fMap[l] = Arrays.copyOf(cMap[l], N);
        }
        for (int k = 0; k < N; k++) {
            stc[k] = new Stack(k, 0, fMap[k][0]);
        }

        for (int j = 1; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (fMap[i][j] == 0) continue;
                Stack s = stc[i];
                if (s.getValue() == 0) {
                    stc[i] = new Stack(i, s.getJ(), fMap[i][j]);
                    fMap[i][s.getJ()] = fMap[i][j];
                    fMap[i][j] = 0;
                } else if (s.getValue() == fMap[i][j] && !s.isCheck()) {
                    stc[i] = new Stack(i, s.getJ(), fMap[i][j] * 2, true);
                    fMap[i][s.getJ()] = fMap[i][j] * 2;
                    fMap[i][j] = 0;
                } else {
                    stc[i] = new Stack(i, s.getJ() + 1, fMap[i][j]);
                    fMap[i][j] = 0;
                    fMap[i][stc[i].getJ()] = stc[i].getValue();
                }
            }
        }

        return dfs(count + 1, fMap);
    }

    static int dfs(int count, int[][] curMap) {
        if (count == 5) {
            int max = -1;
            for (int[] sepMap : curMap) {
                int mValue = Arrays.stream(sepMap).max().getAsInt();
                max = max < mValue ? mValue : max;
            }

            return max;
        }

        int m1 = up(count, curMap);
        int m2 = down(count, curMap);
        int m3 = left(count, curMap);
        int m4 = right(count, curMap);

        int m5 = Math.max(m1, m2);
        int m6 = Math.max(m3, m4);

        return Math.max(m5, m6);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stc = new Stack[N];

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] sl = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(sl[j]);
            }
        }

        System.out.println(dfs(0, map));
    }
}
