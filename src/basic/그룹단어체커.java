package basic;

import java.io.*;

public class 그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            boolean fail = false;

            String s = br.readLine();
            int l = s.length();

            for (int j = 0; j < l; j++) {
                char c = s.charAt(j);
                int last = j;

                for (int k = j + 1; k < l; k++) {
                    if (s.charAt(k) == c) {
                        if (k == last + 1) {
                            last += 1;
                        } else {
                            fail = true;
                            break;
                        }
                    }
                }

                if (fail) {
                    break;
                }
            }

            if (!fail) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
