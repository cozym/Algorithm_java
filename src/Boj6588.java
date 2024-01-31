import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 골드바흐의 추측
public class Boj6588 {
    static int n;
    static boolean[] primes;
    static boolean check;
    static final String WRONG_MESSAGE = "Goldbach's conjecture is wrong.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        primes = new boolean[1000001];
        primes[0] = primes[1] = true;
        for (int i = 2; i*i <= 1000000; i++) {
            if (!primes[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                    primes[j] = true;
                }
            }
        }

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            check = false;
            for (int i = 3; i <= n / 2; i += 2) {
                if (!primes[i] && !primes[n - i]) {
                    bw.write(n + " = " + i + " + " + (n-i) + "\n");
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println(WRONG_MESSAGE);
            }
        }
        bw.close();
    }
}
