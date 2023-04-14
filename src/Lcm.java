import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최소공배수 (1934)
public class Lcm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        String[] arr;
        int a=0, b=0, c=0, t=0;

        for(int i=0; i<r; i++) {
            arr = br.readLine().split(" ");
            a=Integer.parseInt(arr[0]);
            b=Integer.parseInt(arr[1]);
            c = a*b;
            while(b!=0) {
                t = a%b;
                a = b;
                b = t;
            }
            System.out.println(c/a);
        }
    }
}
