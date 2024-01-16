import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 서울 지하철 2호선
public class Boj16947 {
    static int N;
    static ArrayList<Integer>[] station;
    static ArrayList<Integer> circle;
    static ArrayList<Integer> local;
    static boolean[] visited;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        station = new ArrayList[N + 1];
        for (int i = 0; i < station.length; i++) {
            station[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            station[left].add(right);
            station[right].add(left);
        }

        circle = new ArrayList<>();
        local = new ArrayList<>();
        res = new int[N + 1];
        for (int startStation = 1; startStation < station.length; startStation++) {
            visited = new boolean[N + 1];
            defineLocalAndCircleDFS(startStation, startStation, startStation);
        }

        for (int i = 0; i < N; i++) {
            if (!circle.contains(i + 1)) {
                visited = new boolean[N + 1];
                searchMinLocalToCircle(i + 1);
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (i==N) {
                System.out.printf("%d", res[i]);
            } else {
                System.out.printf("%d ", res[i]);
            }
        }
    }

    static void defineLocalAndCircleDFS(int start, int pre, int next) {
        visited[next] = true;

        for (int nextStation : station[next]) {
            if (start == nextStation && pre != nextStation) {
                if (!circle.contains(start)) {
                    circle.add(start);
                }
                return;
            }
            if (!visited[nextStation]) {
                defineLocalAndCircleDFS(start, next, nextStation);
            }
        }
    }

    static void searchMinLocalToCircle(int localStation) {
        int distance = 0;
        visited[localStation] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(localStation);

        while (!q.isEmpty()) {
            int sizeOfQ = q.size();
            for (int i = 0; i < sizeOfQ; i++) {
                int nextStation = q.poll();
                visited[nextStation] = true;
                if (circle.contains(nextStation)) {
                    res[localStation] = distance;
                    return;
                }
                for (int j = 0; j < station[nextStation].size(); j++) {
                    int putInQ = station[nextStation].get(j);
                    if (!visited[putInQ]) {
                        //visited[putInQ] = true;
                        q.offer(putInQ);
                    }
                }
            }
            distance += 1;
        }
    }
}

/*
1. dfs로 각 역의 순환 여부를 파악
2. bfs로 순환에 속하는 역이면 0, 속하지 않는 역이면 최소 순환 거리 판단
 */