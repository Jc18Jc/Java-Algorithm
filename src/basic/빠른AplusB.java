package basic;

import java.io.*;

public class 빠른AplusB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] st = br.readLine().split(" ");
            int result = Integer.parseInt(st[0]) + Integer.parseInt(st[1]);
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
