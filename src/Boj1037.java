import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 약수
public class Boj1037 {
    static long N;
    static ArrayList<Long> A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A.add(Long.parseLong(st.nextToken()));
        }

        System.out.println(Collections.max(A)*Collections.min(A));
    }

    static void LCM(long x,long y) {
        long a,b,t;
        a = x;
        b = y;

        while (b!=0) {
            t = a;
            a = b;
            b = t%b;
        }
    }
}
