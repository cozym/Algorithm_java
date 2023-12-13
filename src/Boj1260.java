import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS
public class Boj1260 {
    static int N, M, V, v1, v2;
    static ArrayList<Integer>[] R;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        R = new ArrayList[N + 1];
        for (int i = 0; i < R.length; i++) {
            R[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            R[v1].add(v2);
            R[v2].add(v1);
        }

        for (int i = 0; i < R.length; i++) {
            Collections.sort(R[i]);
        }
        //System.out.println(Arrays.toString(R));
        visit = new boolean[N + 1];
        dfs(V);

        System.out.println();
        visit = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");

        for (int e : R[v]) {
            if (!visit[e]) {
                dfs(e);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visit[v] = true;
        q.offer(v);

        while (!q.isEmpty()) {
            int checkNode = q.poll();
            System.out.print(checkNode+" ");
            for (int nextNode : R[checkNode]) {
                if (!visit[nextNode]) {
                    visit[nextNode] = true;
                    q.offer(nextNode);
                }
            }
        }
    }
}
