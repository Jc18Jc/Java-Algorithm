package implementation;

import java.io.*;

public class 크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String reg = "c=|c-|dz=|d-|lj|nj|s=|z=";

        String result = s.replaceAll(reg, " ");

        System.out.println(result.length());
    }
}
