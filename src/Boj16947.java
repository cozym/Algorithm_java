import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 서울 지하철 2호선
public class Boj16947 {
    static int N;
    static ArrayList<Integer>[] station;

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

        System.out.println(Arrays.toString(station));
    }
}

/*
1. dfs로 각 역의 순환 여부를 파악
2. bfs로 순환에 속하는 역이면 0, 속하지 않는 역이면 최소 순환 거리 판단
 */