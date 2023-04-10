// 네 수 (10824)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sb = br.readLine().split(" ");
        try {
            long num = Long.parseLong(sb[0] + sb[1]) + Long.parseLong(sb[2] + sb[3]);
            System.out.println(num);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
