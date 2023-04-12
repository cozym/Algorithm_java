// 나머지 (10430)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Remainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] abc = br.readLine().split(" ");

        int a = Integer.parseInt(abc[0]);
        int b = Integer.parseInt(abc[1]);
        int c = Integer.parseInt(abc[2]);

        System.out.println((a+b)%c);
        System.out.println((a%c+b%c)%c);
        System.out.println((a*b)%c);
        System.out.println((a%c*b%c)%c);
    }
}
