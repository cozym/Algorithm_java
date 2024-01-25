import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 찾기
public class Boj1978 {
    static int N, checkNum, count;
    static boolean[] primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        primes = new boolean[1001];
        primes[0] = true;
        primes[1] = true;
        count = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 2; i <= 1000; i++) {
            for (int j = i+i; j <= 1000 ; j+=i) {
                if (!primes[j]) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            checkNum = Integer.parseInt(st.nextToken());
            if (!primes[checkNum]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
