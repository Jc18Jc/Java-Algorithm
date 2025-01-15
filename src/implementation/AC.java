package implementation;

import java.io.*;
import java.util.Arrays;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String commandList = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String inputArray = br.readLine();
            String[] array = inputArray.substring(1, inputArray.length() - 1).split(",");

            int sindex = 0;
            int eindex = n;

            boolean isReverse = false;

            for (int j = 0; j < commandList.length(); j++) {
                char c = commandList.charAt(j);

                if (c == 'R') isReverse = !isReverse;
                else {
                    if (isReverse) eindex -= 1;
                    else sindex += 1;
                }
            }

            if (sindex > eindex) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if (isReverse) {
                for (int j = eindex - 1; j >= sindex; j--) {
                    sb.append(array[j]);
                    sb.append(',');
                }
            } else {
                for (int j = sindex; j < eindex; j++) {
                    sb.append(array[j]);
                    sb.append(',');
                }
            }

            if (sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(']');

            System.out.println(sb);
        }
    }
}
