import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 공약수
public class Boj5618 {
    static int n,m,count;
    static ArrayList<Integer> nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        m = Collections.min(nums);
        for (int i = 1; i <= m; i++) {
            count = 0;
            for (int e : nums) {
                if (e%i != 0) {
                    break;
                }
                count += 1;
                if (count==n) {
                    System.out.println(i);
                }
            }
        }
    }
}
