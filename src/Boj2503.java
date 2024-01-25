import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 숫자 야구
public class Boj2503 {
    static int N,strike,ball,question,res;
    static boolean[] used;
    static ArrayList<numAndPos> update;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        used = new boolean[10];
        update = new ArrayList<>();
        res = 0;

        for (int first = 1; first <= 9; first++) {
            used[first] = true;
            for (int second = 1; second <= 9; second++) {
                if (used[second]) {
                    continue;
                }
                used[second] = true;
                for (int third = 1; third <= 9; third++) {
                    if (!used[third]) {
                        update.add(new numAndPos(String.valueOf(first)+String.valueOf(second)+String.valueOf(third)));
                    }
                }
                used[second] = false;
            }
            used[first] = false;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //question = .nextToken();
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());
            //checkPossibility(question,strike,ball);
        }
    }

    static void checkPossibility(String question, int strike, int ball) {
        for (numAndPos O : update) {
            int localStrike = 0;
            int localBall = 0;
            for (int index = 0; index < 3; index++) {
                //O.num.charAt(index) == question.
            }
        }
    }

    static class numAndPos {
        public String num;
        public boolean possible;
        public numAndPos(String num) {
            this.num = num;
            this.possible = false;
        }
    }
}
