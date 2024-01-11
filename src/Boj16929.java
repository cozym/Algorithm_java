import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Two Dots
public class Boj16929 {
  static int N,M,depth;
  static String res;
  static char[][] pad;
  static boolean[][] visit;
  static int[] moveX = {-1,0,0,1};
  static int[] moveY = {0,-1,1,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    pad = new char[N][M];
    res = "No";

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        pad[i][j] = line.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visit = new boolean[N][M];
        visit[i][j] = true;
        searchCycleDfs(new int[]{i,j},i,j);
      }
    }
    System.out.println(res);
  }

  static void searchCycleDfs(int[] start,int y, int x) {
    int roadBlock = 0;
    for (int i = 0; i < 4; i++) {
      int nextX = x + moveX[i];
      int nextY = y + moveY[i];
      if (start[0] == nextY && start[1] == nextX && depth >= 3) {
        res = "Yes";
        return;
      }
      if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && !visit[nextY][nextX] && pad[y][x] == pad[nextY][nextX]) {
        visit[y][x] = true;
        depth++;
        searchCycleDfs(start,nextY,nextX);
      } else {
        roadBlock++;
      }
      if (roadBlock==4) {
        depth = 0;
      }
    }
  }
}
