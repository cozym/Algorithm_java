import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 뒤집어진 소수
public class Boj10859 {
    static String N,res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        res = "yes";

        if (!checkPrime(Long.parseLong(N)) || !checkPrime(reverseDigit(N))) {
            res = "no";
        }
        System.out.println(res);
    }

    static long reverseDigit(String n) {
        StringBuilder r = new StringBuilder();

        for (int i = n.length()-1; i >= 0; i--) {
            String c = String.valueOf(n.charAt(i));
            if ("347".contains(c)) {
                res = "no";
                return -1;
            } else if (c.equals("6")) {
                c = "9";
            } else if (c.equals("9")) {
                c = "6";
            }
            r.append(c);
        }
        return Long.parseLong(String.valueOf(r));
    }

    static boolean checkPrime(long n) {
        if (n==1) {
            return false;
        }
        for (long i = 2; i*i <= n; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
