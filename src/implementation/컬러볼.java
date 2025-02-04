package implementation;

import java.io.*;
import java.util.*;

class Element implements Comparable<Element> {
    int s;
    int c;
    int index;

    public Element(int c, int s, int i) {
        this.s = s;
        this.c = c;
        this.index = i;
    }

    public int getS() {
        return s;
    }

    public int getC() {
        return c;
    }

    public int getIndex() {
        return index;
    }

    public int compareTo(Element e) {
        return this.s - e.getS();
    }
}

public class 컬러볼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int i;

        Element[] elementArray = new Element[N];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            elementArray[i] = (new Element(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }

        Arrays.sort(elementArray);

        int flagNumber = 0;
        int[] sumColor = new int[N + 1];
        int stackValue = 0;
        int newValue = 0;
        int[] board = new int[N + 1];
        Map<Integer, Integer> colorMap = new HashMap<>();

        for (i = 0; i < N; i++) {
            Element e = elementArray[i];
            int s = e.getS();
            int c = e.getC();
            int index = e.getIndex();

            if (flagNumber != s) {
                stackValue += newValue;
                flagNumber = s;
                newValue = 0;
                colorMap.clear();
            }

            int tmpNum = colorMap.containsKey(c) ? colorMap.get(c) : 0;
            board[index] = stackValue - sumColor[c] + tmpNum;
            sumColor[c] += s;
            colorMap.put(c, tmpNum + s);
            newValue += s;
        }

        for (i = 0; i < N; i++) {
            System.out.println(board[i]);
        }

    }
}
