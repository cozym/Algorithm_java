import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 뒤집어진 소수
public class Boj10859 {
    static String N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();

        System.out.println(N);
    }

    static long reverseDigit(String n) {
        StringBuilder r = new StringBuilder();
        String same = "0258";
        String move = "1";
        String change = "";

        for (int i = n.length()-1; i >= 0; i--) {
            String c = String.valueOf(n.charAt(i));
            if ("347".contains(c)) {
                return -1;
            }
            if (c.equals("6")) {
                c = "9";
            } else if (c.equals("9")) {
                c = "6";
            }
            r.append(c);
        }
    }

    static void checkPrime() {

    }
}
