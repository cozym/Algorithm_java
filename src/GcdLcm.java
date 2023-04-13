import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대공약수와 최소공배수 (2609)
public class GcdLcm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int t = 0;
        int lcm = a*b;

        while(b!=0) {
            t = a%b;
            a=b;
            b=t;
        }

        System.out.println(a);
        System.out.print(lcm/a);
    }
}
