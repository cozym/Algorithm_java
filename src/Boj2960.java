import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체
public class Boj2960 {
    static int N, K, count;
    static boolean[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;
        primes = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j+=i) {
                if (!primes[j]) {
                    count++;
                    primes[j] = true;
                }
                if (count==K) {
                    System.out.println(j);
                    break;
                }
            }
            if (count==K) {
                break;
            }
        }
    }
}
