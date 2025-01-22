package implementation;

import java.io.*;
import java.util.*;

public class 치킨배달 {
    static ArrayList<Node> houseList = new ArrayList<>();
    static ArrayList<Node> cList = new ArrayList<>();
    static ArrayList<Node> selectList = new ArrayList<>();
    static int N;
    static int M;

    static int dfs(int index) {
        int size = selectList.size();
        if (size == M) {
            int total = 0;
            for (Node houseNode : houseList) {
                int minNode = 100000000;
                for (Node selectNode : selectList) {
                    int dist = Math.abs(houseNode.getI() - selectNode.getI()) + Math.abs(houseNode.getJ() - selectNode.getJ());
                    minNode = minNode < dist ? minNode : dist;
                }
                total += minNode;
            }

            return total;
        } else if (index < cList.size()) {
            int min = 1000000000;
            for (int k = index + 1; k < cList.size(); k++) {
                selectList.add(cList.get(k));
                int result = dfs(k);
                min = min < result ? min : result;
                selectList.remove(size);
            }
            return min;
        }

        return 1000000000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String[] sList = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int point = Integer.parseInt(sList[j]);
                if (point == 1) houseList.add(new Node(i, j));
                if (point == 2) cList.add(new Node(i, j));
            }
        }
        System.out.println(dfs(-1));
    }
}
