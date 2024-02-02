import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class Boj1697 {
    static int N,K,res;
    static boolean e;
    static boolean[] visited;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        visited = new boolean[100001];
        res = 0;
        e = true;
        q.add(N);

        while (true) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int current = q.poll();
                if (current == K) {
                    e = false;
                    System.out.println(res);
                    break;
                }
                validateRange(current+1);
                validateRange(current-1);
                validateRange(current*2);
            }
            if (!e) {
                break;
            }
            res++;
        }
    }

    static void validateRange(int location) {
        if (0 <= location && location <= 100000 && !visited[location]) {
            visited[location] = true;
            q.add(location);
        }
    }
}