package implementation;

import java.io.*;
import java.util.*;

public class 야구 {
    public static boolean[] field = new boolean[4];
    public static int[] order = new int[9];
    public static int max_score = 0;
    public static boolean[] playerChecker = new boolean[9];
    public static int N;
    public static int[][] gain;

    public static int calc(int type) {
        int plus = 0;
        if (type == 4) {
            for (boolean b : field) {
                if (b) {
                    plus += 1;
                }
            }
            Arrays.fill(field, false);
            return plus + 1;
        }

        for (int i = 2; i > -1; i--) {
            if (field[i]) {
                if (type + i >= 3) {
                    plus += 1;
                } else {
                    field[type + i] = true;
                }
                field[i] = false;
            }
        }

        field[type - 1] = true;

        return plus;
    }

    public static void perm(int index) {
        if (index == 3) {
            order[index] = 0;
            perm(index + 1);
            return;
        }

        if (index == 9) {
            int result = game();
            max_score = Math.max(result, max_score);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (playerChecker[i]) continue;
            playerChecker[i] = true;
            order[index] = i;
            perm(index + 1);
            playerChecker[i] = false;
        }
    }

    public static int game() {
        int total = 0;
        int base = 0;
        for (int i = 0; i < N; i++) {
            int outCount = 0;
            Arrays.fill(field, false);
            while (outCount != 3) {
                int type = gain[i][order[base]];
                base = (base + 1) % 9;
                if (type == 0) {
                    outCount += 1;
                    continue;
                }
                total += calc(type);
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int i, j;

        gain = new int[N][9];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < 9; j++) {
                gain[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(field, false);
        Arrays.fill(playerChecker, false);

        perm(0);
        System.out.println(max_score);
    }
}
