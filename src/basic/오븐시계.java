package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오븐시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] time = br.readLine().split(" ");

        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);

        int C = Integer.parseInt(br.readLine());

        int aHour = C / 60;
        int aMin = C % 60;

        int tmpMin = min + aMin;
        int tmpHour = hour + aHour + tmpMin / 60;

        int pHour = tmpHour >= 24 ? tmpHour - 24 : tmpHour;
        int pMin = tmpMin % 60;

        System.out.printf("%d %d", pHour, pMin);
    }
}
