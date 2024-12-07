package basic;

import java.io.*;
import java.util.StringTokenizer;

public class 알람시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        if (min >= 45) {
            min -= 45;
        } else {
            min = min + 60 - 45;
            if (hour == 0) {
                hour = 23;
            } else {
                hour -= 1;
            }
        }

        System.out.printf("%d %d", hour, min);
    }
}
