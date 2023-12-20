import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2667 {
    static int N,count;
    static int[][] map;
    static int[] rightLeft = {1, 0, -1, 0};
    static int[] upDown = {0, 1, 0, -1};
    static boolean[][] visit;
    static ArrayList<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N][N];
        res = new ArrayList<>();

        map = new int[N][N];
        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < N; col++) {
                map[row][col] = line.charAt(col) - '0';
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (!visit[row][col] && map[row][col] == 1) {
                    visit[row][col] = true;
                    count = 1;
                    countHomeDfs(row,col);
                    res.add(count);
                }
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        for (int c : res) {
            System.out.println(c);
        }

    }

    static void countHomeDfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + rightLeft[i];
            int nextY = y + upDown[i];
            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                if (!visit[nextX][nextY] && map[nextX][nextY] == 1) {
                    visit[nextX][nextY] = true;
                    count++;
                    countHomeDfs(nextX, nextY);
                }
            }
        }
    }
}
