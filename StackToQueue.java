import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void pushc(int node) {
        stack1.push(node);
    }

    public int popc() {
        if (stack2.empty()&&stack1.empty()) {
            throw new RuntimeException ("Queue is empty");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public  static void main(String[] args) {
        StackToQueue s = new StackToQueue();
        s.pushc(12);
        s.pushc(4);

        s.pushc(6);
        s.popc();
        System.out.println(s.popc());
        System.out.println(s.popc());
    }
}