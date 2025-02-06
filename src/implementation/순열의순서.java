package implementation;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.IntStream;

public class 순열의순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());
        if (type == 1) {
            Long o = Long.parseLong(st.nextToken()) - 1;
            Long M = 1L;
            int mul = N - 1;
            int[] cand = new int[N];
            for (i = 1; i < N + 1; i++) {
                cand[i - 1] = i;
                M *= i;
            }
            M /= N;
            List<Integer> result = new ArrayList<>();
            while (mul > 0) {
                Long target = o / M;
                result.add(cand[target.intValue()]);
                cand = IntStream.concat(Arrays.stream(Arrays.copyOf(cand, target.intValue())), Arrays.stream(Arrays.copyOfRange(cand, target.intValue() + 1, cand.length))).toArray();
                o %= M;
                M /= mul;
                mul -= 1;
            }
            result.add(cand[0]);
            for (Integer number : result) {
                System.out.print(number);
                System.out.print(" ");
            }

        } else {
            int[] numbers = new int[N];
            for (i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            Long M = 1L;
            int mul = N - 1;
            int[] cand = new int[N];
            for (i = 1; i < N + 1; i++) {
                cand[i - 1] = i;
                M *= i;
            }
            M /= N;
            Long result = 1L;

            for (i = 0; i < N - 1; i++) {
                int index = Arrays.binarySearch(cand, numbers[i]);
                result += M * index;
                cand = IntStream.concat(Arrays.stream(Arrays.copyOf(cand, index)), Arrays.stream(Arrays.copyOfRange(cand, index + 1, cand.length))).toArray();
                M /= mul;
                mul -= 1;
            }

            System.out.println(result);
        }
    }
}
