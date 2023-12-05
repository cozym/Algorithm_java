import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023 {
    private static ArrayList<Integer>[] relationship;
    private static boolean[] visit;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        result = 0;
        relationship = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            relationship[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relationship[a].add(b);
            relationship[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (result==0) {
                dfs(i, 0);
            }
        }
        System.out.println(result);
    }

    static void dfs(int idx, int depth) {
        if (depth==4) {
            result = 1;
            return; // 스택 탈출
        }
        visit[idx] = true;
        for (int i : relationship[idx]) {
            if (!visit[i]) {
                dfs(i, depth + 1);
            }
        }
        visit[idx] = false;
    }
}
