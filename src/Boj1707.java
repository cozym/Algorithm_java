import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1707 {
    static int K, V, E, v1, v2;
    static ArrayList<Integer>[] R;
    static boolean[] visit;
    static int[] kinds;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < K; testcase++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            R = new ArrayList[V + 1];
            visit = new boolean[V + 1];
            kinds = new int[V + 1];
            res = "YES";
            for (int numOfVertices = 0; numOfVertices <= V; numOfVertices++) {
                R[numOfVertices] = new ArrayList<>();
            }
            kinds[1] = 1;
            for (int numOfEdge = 0; numOfEdge < E; numOfEdge++) {
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                R[v1].add(v2);
                R[v2].add(v1);
            }
            dfs(1);
            System.out.println(res);
        }
    }

    static void dfs(int node) {
        visit[node] = true;
        for (int nextNode : R[node]) {
            if (!visit[nextNode]) {
                if (kinds[node] == kinds[nextNode]) {
                    res = "NO";
                    return;
                } else if (kinds[nextNode] == 0) {
                    kinds[nextNode] = kinds[node]==1 ? 2 : 1;
                }
                dfs(nextNode);
            }
        }
        visit[node] = false;
    }
}
