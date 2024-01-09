import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    static int M,N,res;
    static int[][] storage;
    static Queue<int[]> q;
    static int[] side = {-1,0,0,1};
    static int[] upDown = {0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        storage = new int[N][M];
        q = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int num = Integer.parseInt(st.nextToken());
                storage[n][m] = num;
                if (num==1) {
                    q.offer(new int[]{n,m});
                }
            }
        }

        tomatoBFS();

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (storage[n][m] == 0) {
                    res = 0;
                }
            }
        }

        System.out.println(res-1);
    }

    static void tomatoBFS() {

        while (!q.isEmpty()) {
            int currentQSize = q.size();

            for (int i = 0; i < currentQSize; i++) {
                int[] coordinate = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nextY = coordinate[0] + side[j];
                    int nextX = coordinate[1] + upDown[j];
                    if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
                        if (storage[nextY][nextX] == 0) {
                            storage[nextY][nextX] = 1;
                            q.offer(new int[]{nextY,nextX});
                        }
                    }
                }
            }
            res++;
        }
    }
}
