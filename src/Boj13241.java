import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소공배수
public class Boj13241 {
    static long A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        LCM(A,B);
    }

    static void LCM(long a, long b) {
        long x,y,t;
        x = a;
        y = b;
        while (y!=0) {
            t = x;
            x = y;
            y = t%y;
        }
        System.out.println(a/x*b);
    }
}

// 최소공배수 = (a * b) / 최대공약수
