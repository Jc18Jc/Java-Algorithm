package implementation;

import java.io.*;
import java.util.*;

public class 연구소 {
    static int N;
    static int M;
    static Queue<Node> q = new LinkedList<>();
    static ArrayList<Node> virusList = new ArrayList<>();
    static ArrayList<Node> emptyList = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int checkSafe(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }

        return count;
    }

    static int bfs(int[][] map2) {
        q.clear();
        for (Node n : virusList) {
            q.add(n);
        }

        while (!q.isEmpty()) {
            Node popNode = q.remove();
            int ci = popNode.getI();
            int cj = popNode.getJ();
            for (int t = 0; t < 4; t++) {
                int ni = ci + dx[t];
                int nj = cj + dy[t];
                if (-1 < ni && ni < N) {
                    if (-1 < nj && nj < M) {
                        if (map2[ni][nj] == 0) {
                            q.add(new Node(ni, nj));
                            map2[ni][nj] = 2;
                        }
                    }
                }
            }
        }

        return checkSafe(map2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer lst = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(lst.nextToken());
                if (map[i][j] == 2) virusList.add(new Node(i, j));
                if (map[i][j] == 0) emptyList.add(new Node(i, j));
            }
        }

        int len = emptyList.size();

        if (len < 3) {
            for (Node n : emptyList) {
                map[n.getI()][n.getJ()] = 1;
            }
            int count = bfs(map);
            System.out.println(count);
            return;
        }

        int answer = 0;

        for (int i = 0; i < len - 2; i++) {
            Node node1 = emptyList.get(i);
            for (int j = i + 1; j < len - 1; j++) {
                Node node2 = emptyList.get(j);
                for (int k = j + 1; k < len; k++) {
                    Node node3 = emptyList.get(k);
                    int[][] newMap = new int[N][M];
                    for (int l = 0; l < N; l++) {
                        newMap[l] = Arrays.copyOf(map[l], M);
                    }

                    newMap[node1.getI()][node1.getJ()] = 1;
                    newMap[node2.getI()][node2.getJ()] = 1;
                    newMap[node3.getI()][node3.getJ()] = 1;
                    int count = bfs(newMap);
                    answer = answer < count ? count : answer;
                }
            }
        }

        System.out.println(answer);
    }
}