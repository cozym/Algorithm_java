import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stack {
    private int top;
    private int size;
    private int []Stack;

    public stack(int size) {
        this.top = -1;
        this.size = size;
        Stack = new int[size];
    }

    public void push(int X) {
        Stack[++top] = X;
    }

    public void pop() {
        if (top == -1) {
            System.out.println(-1);
        }
        else {
            System.out.println(Stack[top]);
            Stack[top--] = 0;
        }
    }

    public void size() {
        System.out.println(top+1);
    }

    public void empty() {
        if(this.top == -1)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public void top() {
        if(this.top == -1)
            System.out.println(-1);
        else
            System.out.println(this.Stack[top]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(bf.readLine());
        stack s = new stack(L);

        for(int i=0; i<L; i++) {
            String []commend = bf.readLine().split(" ");
            if (commend[0].equals("push"))
                s.push(Integer.parseInt(commend[1]));
            else if (commend[0].equals("pop"))
                s.pop();
            else if (commend[0].equals("size"))
                s.size();
            else if (commend[0].equals("empty"))
                s.empty();
            else if (commend[0].equals("top"))
                s.top();
        }
    }
}
