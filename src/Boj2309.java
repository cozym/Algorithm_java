import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 일곱 난쟁이
public class Boj2309 {
    static ArrayList<Integer> heights;
    static ArrayList<Integer> resForPrint;
    static ArrayList<Integer> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        res = new ArrayList<>();
        heights = new ArrayList<>();


        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            heights.add(Integer.parseInt(st.nextToken()));
        }

        detectSeven(0);

    }

    static void detectSeven(int index) {
        int sum = 0;
        if (res.size() == 7) {
            for (int e : res) {
                sum += e;
            }
            if (sum == 100) {
                resForPrint = new ArrayList<>(res);
                Collections.sort(resForPrint);
                for (int i = 0; i < 7; i++) {
                    System.out.println(resForPrint.get(i));
                }
                System.exit(0);
            }
            return;
        }
        if (index >= heights.size()) {
            return;
        }
        res.add(heights.get(index));
        detectSeven(index+1);
        res.remove(res.size()-1);
        detectSeven(index+1);
    }
}
