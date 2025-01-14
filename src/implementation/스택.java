package implementation;

import java.io.*;
import java.util.*;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> stc = new ArrayList();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            String[] sl = s.split(" ");

            int size = stc.size();

            switch (sl[0]) {
                case "push":
                    stc.add(Integer.parseInt(sl[1]));
                    break;
                case "top":
                    if (size == 0)
                        System.out.println(-1);
                    else
                        System.out.println(stc.get(size - 1));
                    break;
                case "pop":
                    if (size == 0)
                        System.out.println(-1);
                    else
                        System.out.println(stc.remove(size - 1));
                    break;
                case "size":
                    System.out.println(size);
                    break;
                case "empty":
                    if (size == 0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                default:
                    System.out.println("error");

            }
        }
    }
}
