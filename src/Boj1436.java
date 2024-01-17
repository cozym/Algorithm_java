import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 영화감독 숌
public class Boj1436 {
    static int N,mustThreeSix, count;
    static ArrayList<Integer> toFindMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mustThreeSix = 666;
        count = 1;

        while (count < N) {
            mustThreeSix++;
            if (Integer.toString(mustThreeSix).contains("666")) {
                count++;
            }
        }

        System.out.println(mustThreeSix);
    }
}
