import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1707 {
    static final int GROUP_A = 1;
    static final int GROUP_B = 2;
    static int K, V, E, v1, v2;
    static ArrayList<Integer>[] R;
    static boolean[] visit;
    static int[] groups;
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
            groups = new int[V + 1];
            res = "YES";
            for (int numOfVertices = 0; numOfVertices <= V; numOfVertices++) {
                R[numOfVertices] = new ArrayList<>();
            }
            for (int numOfEdge = 0; numOfEdge < E; numOfEdge++) {
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                R[v1].add(v2);
                R[v2].add(v1);
            }
            for (int edge = 1; edge <= V; edge++) {
                if (!visit[edge]) {
                    bfs(edge);
                }
            }
            System.out.println(res);
        }
    }

//    static void dfs(int node, int group) {
//        visit[node] = true;
//        if (groups[node] == 0) {
//            groups[node] = group;
//        }
//        for (int nextNode : R[node]) {
//            if (groups[node] == groups[nextNode]) {
//                res = "NO";
//                return;
//            }
//            if (!visit[nextNode]) {
//                dfs(nextNode, groups[node] == GROUP_A ? GROUP_B : GROUP_A);
//            }
//        }
//    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        groups[node] = GROUP_A;

        while(!q.isEmpty()) {
            int currentNode = q.poll();
            visit[currentNode] = true;
            for (int nextNode : R[currentNode]) {
                if (groups[currentNode] == groups[nextNode]) {
                    res = "NO";
                    return;
                }
                if (!visit[nextNode]) {
                    groups[nextNode] = groups[currentNode] == GROUP_A ? GROUP_B : GROUP_A;
                    q.offer(nextNode);
                }
            }
        }
    }
}
