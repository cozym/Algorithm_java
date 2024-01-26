import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소공배수
public class Boj1934 {
    static int T,A,B,g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            gcd(A,B);
            System.out.println((A*B)/g);
        }
    }

    static void gcd(int x, int y) {
        int tmp;
        if (y==0) {
            g = x;
            return;
        }
        tmp = y;
        y = x%y;
        x = tmp;
        gcd(x,y);
    }
}
