package basic;

import java.io.*;
import java.util.StringTokenizer;

public class AdivB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());

        bw.write(String.valueOf(a / b));
        bw.flush();
    }
}