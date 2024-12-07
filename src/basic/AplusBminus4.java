package basic;

import java.io.*;

public class AplusBminus4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            String[] splitedString = input.split(" ");
            int result = Integer.parseInt(splitedString[0]) + Integer.parseInt(splitedString[1]);
            sb.append(result + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
