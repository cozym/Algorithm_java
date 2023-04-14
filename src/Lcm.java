import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최소공배수 (1934)
public class Lcm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        int[] arr = new int[2];

        for(int i=0; i<c; i++) {
            arr = br.readLine().split(' ').toString();
        }

    }
}
