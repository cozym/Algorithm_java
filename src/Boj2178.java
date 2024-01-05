import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class Boj2178 {
    static int N,M,res;
    static int[] moveSide = {-1,0,0,1};
    static int[] moveUpDown = {0,-1,1,0};
    static int[][] map;
    static int[][] distance;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        distance = new int[N][M];
        distance[0][0] = 1;
        res = 10000;

        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = line.charAt(col) - '0';
            }
        }
        searchShortest();
        System.out.println(distance[N-1][M-1]);
    }

    static void searchShortest() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        while(!q.isEmpty()) {
            int[] currentPoint = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint[1] + moveSide[i];
                int nextY = currentPoint[0] + moveUpDown[i];
                if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
                    if (!visit[nextY][nextX] && map[nextY][nextX] == 1) {
                        visit[nextY][nextX] = true;
                        distance[nextY][nextX] = distance[currentPoint[0]][currentPoint[1]] + 1;
                        q.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
