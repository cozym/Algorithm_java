import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 섬의 개수
public class Boj4963 {
    static int w,h,res;
    static int[] checkWidth = {-1,0,1,-1,1,-1,0,1};
    static int[] checkVertical = {-1,-1,-1,0,0,1,1,1};
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            res = 0;
            if (w==0 && h==0) {
                break;
            }
            map = new int[h][w];
            visit = new boolean[h][w];

            // 주어진 테스트케이스 맵 입력
            for (int row = 0; row < h; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < w; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            // 맵 순회하며 dfs로 섬의 개수 카운트
            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (!visit[row][col] && map[row][col]==1) {
                        countLand(col,row,h,w);
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }

    static void countLand(int x, int y, int h, int w) {
        for (int i = 0; i < 8; i++) {
            int nextX = x+checkWidth[i];
            int nextY = y+checkVertical[i];
            if (0 <= nextX && nextX < w && 0 <= nextY && nextY < h) {
                if (!visit[nextY][nextX] && map[nextY][nextX]==1) {
                    visit[nextY][nextX] = true;
                    countLand(nextX,nextY,h,w);
                }
            }
        }
    }
}
