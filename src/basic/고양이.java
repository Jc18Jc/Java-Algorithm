package basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 고양이 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] cats = {
                "\\    /\\",
                " )  ( ')",
                "(  /  )",
                " \\(__)|"
        };

        for (String s : cats) {
            try {
                bw.write(s + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        bw.flush();
    }
}
