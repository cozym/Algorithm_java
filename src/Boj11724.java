import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class Boj11724 {
    static int N, M, u, v;
    static int res = 0;
    static boolean[] visit;
    static ArrayList<Integer>[] R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        R = new ArrayList[N + 1];
        for (int i = 0; i < R.length; i++) {
            R[i] = new ArrayList<>();
        }

        for (int e = 0; e < M; e++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            R[u].add(v);
            R[v].add(u);
        }

        visit = new boolean[N + 1];
        for (int startNode = 1; startNode <= N; startNode++) {
            if (!visit[startNode]) {
                res++;
                dfs(startNode);
            }
        }
        System.out.println(res);
    }

    static void dfs(int node) {
        visit[node] = true;
        for (int connectNode : R[node]) {
            if (!visit[connectNode]) {
                dfs(connectNode);
            }
        }
    }
}
