import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 슈퍼 마리오
public class Boj2851 {
    static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = 0;
        for (int i = 0; i < 10; i++) {
            int mushroom = Integer.parseInt(br.readLine());
            if (Math.abs(100-s) >= Math.abs(100-(s+mushroom))) {
                s += mushroom;
            } else {
                break;
            }
        }
        System.out.println(s);
    }
}
