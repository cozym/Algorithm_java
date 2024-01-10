import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
public class Boj7562 {
  static int N,side,res;
  static int[] moveX = {-2,-2,-1,-1,1,1,2,2};
  static int[] moveY = {-1,1,-2,2,-2,2,-1,1};
  static int[] start = new int[2];
  static int[] goal = new int[2];
  static boolean[][] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      side = Integer.parseInt(st.nextToken());
      visit = new boolean[side][side];
      st = new StringTokenizer(br.readLine());
      start[0] = Integer.parseInt(st.nextToken());
      start[1] = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      goal[0] = Integer.parseInt(st.nextToken());
      goal[1] = Integer.parseInt(st.nextToken());

      res = 0;
      chessBFS();
    }
  }
  static void chessBFS() {
    Queue<int[]> q = new LinkedList<>();
    q.offer(start);

    if (start[0] == goal[0] && start[1] == goal[1]) {
      System.out.println(0);
      return;
    }

    while (!q.isEmpty()) {
      int sizeOfQ = q.size();
      res++;
      for (int i = 0; i < sizeOfQ; i++) {
        int[] current = q.poll();
        for (int j = 0; j < 8; j++) {
          int nextY = current[0] + moveY[j];
          int nextX = current[1] + moveX[j];
          if (0 <= nextY && nextY < side && 0 <= nextX && nextX < side && !visit[nextY][nextX]) {
            visit[nextY][nextX] = true;
            q.offer(new int[]{nextY, nextX});
            if (nextY == goal[0] && nextX == goal[1]) {
              System.out.println(res);
              return;
            }
          }
        }
      }
    }
  }
}
